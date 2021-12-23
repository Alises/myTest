package com.example.demo.datastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Create 2021/12/10 by Gq
 * 红黑树：
 * 特性：
 * 1. 红黑树的节点不是红色就是黑色
 * 2. 红黑树的跟节点必须是黑色
 * 3. 每个叶子节点都是黑色的。（这里的叶子节点指的是为空的叶子节点）
 * 4. 如果一个节点为红色，那么他的子节点必须是黑色
 * 5. 任何节点到其分枝叶子的简单路径，所经过的黑色节点的数量是一样的
 */
public class RedBlackTree<T> {

    private Node root;

    /**
     * 插入节点
     */
    public boolean insert(Node node) {
        if(node == null) return false;
        // 当前比较的节点
        Node cur = null;
        // 下一个节点
        Node next = root;
        while (next != null) {
            cur = next;
            if(node.value < cur.value) {
                next = next.left;
            } else {
                next = next.right;
            }
        }

        // 找到插入位置后将当前node的父节点设置为上一个节点
        node.parent = cur;
        if(cur != null) {
            if(node.value < cur.value) {
                cur.left = node;
            } else {
                cur.right = node;
            }
        } else {
            root = node;
        }

        // 修正树
        insertFixed(node);
        return true;
    }

    public boolean insert(Integer i) {
        return insert(new Node(i));
    }

    /**
     * 删除节点
     * @param node
     */
    public boolean remove(Node node) {
        // replace 表示删除后顶替的节点 parent 为replace的父节点
        Node replace = null;
        // 如果删除的节点左右孩子都有
        if(node.left != null && node.right != null) {
            Node succ = node.right;
            while (succ.left != null) {
                succ = succ.left;
            }
            // 替换要删除节点的值
            node.value = succ.value;
            return remove(succ);
        } else {  // 叶子或只有一个子节点的情况
            // 如果删除的是根，则root指向其子节点
            if(node.parent == null) {
                root = (node.left != null ? node.left : node.right); // 可能有 可能为null
                replace = root;
                if(root != null) {
                    root.parent = null;
                }
            } else {   // 删除非根
                // 找到删除节点的子节点
                Node child = (node.left != null ? node.left : node.right);
                // 判断要删除的节点是父节点的左节点还是右子节点    然后把自己的子节点放到父节点的子节点上
                if(node == node.parent.left) {
                    node.parent.left = child;
                } else {
                    node.parent.right = child;
                }

                if(child != null) {
                    child.parent = node.parent;
                }
                replace = child;
            }
        }
        // 如果删除的节点是红色 则直接结束
        if(!node.red) {
            removeFixed(replace);
        }
        return true;
    }

    public boolean remove(int i) {
        Node next = root;
        while (next != null) {
            if(next.value == i) {
                return remove(next);
            } else if(next.value > i) {
                next = next.left;
            } else {
                next = next.right;
            }
        }
        return false;
    }

    /**
     * 修正红黑树
     */
    private void insertFixed(Node node) {
        Node parent, gParent;
        // 如果存在父节点，并且父节点是红色
        while ((parent = node.parent) != null && parent.red) {
            gParent = parent.parent;
            // 如果父节点是祖父节点的左节点
            if(parent == gParent.left) {
                Node uncle = gParent.right;
                // 如果存在叔叔节点， 并且叔叔是红色
                if((uncle != null) && uncle.red) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gParent);
                    node = gParent;
                    continue;
                }
                // 如果叔叔是黑节点，且当前节点是右节点  LR
                if(parent.right == node) {
                    leftRotate(parent);
                    Node tem = parent;
                    parent = node;
                    node = tem;
                }
                // 如果叔叔是黑节点，且当前节点是左节点 LL
                setBlack(parent);
                setRed(gParent);
                rightRotate(gParent);
            } else {    // 若父节点是祖父节点的有节点
                Node uncle = gParent.left;
                // 如果叔叔节点存在并且是红色
                if(uncle != null && uncle.red) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gParent);
                    node = gParent;
                    continue;
                }
                // 叔叔是黑色节点  且当前节点是左节点  RL
                if(node == parent.left) {
                    rightRotate(parent);
                    Node tem = parent;
                    parent = node;
                    node = tem;
                }
                // 叔叔是黑色   且当前节点是右节点 RR
                setBlack(parent);
                setRed(gParent);
                leftRotate(gParent);
            }
        }
        setBlack(root);
    }

    /**
     * 删除后修正树
     * @param replace   顶提的节点
     */
    private void removeFixed(Node replace) {
        Node parent = replace.parent, brother;
        // 如果顶替节点是黑色节点  并且不是跟节点
        while (!replace.red && root != replace) {
            // 如果顶替的节点是左子节点
            if(parent == parent.left) {
                // 获取到兄弟节点
                brother = parent.right;
                // case 1 兄弟节点为红色, brother涂黑,parent涂红,parent左旋，replace兄弟变了，变成了黑兄的情况
                if(brother.red) {
                    setBlack(brother);
                    setRed(parent);
                    leftRotate(parent);
                    brother = parent.right;
                }
                // 经过上面的逻辑  不管有没有进if都变成黑兄
                // case 2 黑兄，且兄弟两个子节点都是黑色
                if((brother.left == null || !brother.left.red)
                        && (brother.right == null || !brother.right.red)) {
                    // 如果父节点是红色  则把brother的黑转移到父节点上
                    if(parent.red) {
                        setBlack(parent);
                        setRed(brother);
                        break;
                    } else {
                        // 如果父节点是黑色，即现在所有的节点都是黑色，则把brother涂红，
                        // 这样会导致整个分之少一个黑色，则需要对parent进行新一轮的调整
                        setRed(brother);
                        replace = parent;
                        parent = replace.parent;
                    }
                } else {
                    // case 3 黑兄，兄弟的左孩子为红色
                    if(brother.left != null && brother.left.red) {
                        brother.left.red = parent.red;
                        setBlack(parent);
                        rightRotate(brother);
                        leftRotate(parent);
                    // case 4 黑兄， 兄弟的右孩子为红色
                    } else if(brother.right != null && brother.right.red) {
                        brother.red = parent.red;
                        setBlack(brother.right);
                        setBlack(parent);
                        leftRotate(parent);
                    }
                    break;
                }
            } else {
                // 获取到兄弟节点
                brother = parent.left;
                // case 1 红兄, brother涂黑,parent涂红,parent右旋，replace兄弟变了，变成了黑兄的情况
                if(brother.red) {
                    setBlack(brother);
                    setRed(parent);
                    rightRotate(parent);
                    brother = parent.left;
                }
                // 经过上面的逻辑  不管有没有进if都变成黑兄
                // case 2 黑兄，且兄弟两个子节点都是黑色
                if((brother.left == null || !brother.left.red)
                        && (brother.right == null || !brother.right.red)) {
                    // 如果父节点是红色  则把brother的黑转移到父节点上
                    if(parent.red) {
                        setBlack(parent);
                        setRed(brother);
                        break;
                    } else {
                        // 如果父节点是黑色，即现在所有的节点都是黑色，则把brother涂红，
                        // 这样会导致整个分之少一个黑色，则需要对parent进行新一轮的调整
                        setRed(brother);
                        replace = parent;
                        parent = replace.parent;
                    }
                } else {
                    // case 3 黑兄，兄弟的左孩子为红色,右孩子随意
                    if(brother.right != null && brother.right.red) {
                        brother.right.red = parent.red;
                        setBlack(parent);
                        leftRotate(brother);
                        rightRotate(parent);
                    // case 4  黑兄，兄弟的右孩子为红色，左孩子随意
                    } else if(brother.left != null && brother.left.red) {
                        brother.red = parent.red;
                        setBlack(brother.left);
                        setBlack(parent);
                        rightRotate(parent);
                    }
                    break;
                }
            }
        }
        // 这里可以处理到删除节点为只有一个孩子节点的情况，如果是根，也会将其涂黑
        setBlack(replace);
    }

    /**
     * 左旋
     * @param node 当前节点  下图的x
     *
     *          px                         px
     *         /  \                       /  \
     *        x   z    --- x左旋          y   z
     *       / \   \                    / \   \
     *      w  y   u                   x   p   u
     *        / \                    /  \
     *       q   p                  w    q
     */
    private void leftRotate(Node node) {
        // 获取到右子树
        Node right = node.right;
        // 将x的右节点变成 y的左节点  并将子节点的父节点指向x
        node.right = right.left;
        if(node.right != null) {
            node.right.parent = node;
        }
        // 将y的父节点 换成x节点的父节点 2. 重置y的父指针
        right.parent = node.parent;
        // 如果父节点为空 设置树的根
        if(right.parent == null) {
            root = right;
        } else {
            // 如果x是父节点的左子树
            if(node == node.parent.left) {
                // 将y的变成x父节点的左子树
                node.parent.left = right;
            } else {
                // 将y的变成x父节点的右子树
                node.parent.right = right;
            }
        }
        // 将y的左子树变成x 并将x的父节点变成y
        right.left = node;
        node.parent = right;
    }

    /**
     * 右旋
     * @param node  当前节点  下图中的x
     *              px                                         px
     *             /  \                                      /    \
     *           q     p                                   q       p
     *         /  \   /  \                                /  \    /  \
     *        o   w  r    x      ----- x 右旋            o    w   r    y
     *                  /  \                                         /  \
     *                 y   z                                        t    x
     *               /  \                                               /  \
     *              t    u                                             u    z
     */
    private void rightRotate(Node node) {
        // 获取到当前节点的左节点
        Node left = node.left;
        // 将x的左子树变成 y的右子树 并重置子树的父指针
        node.left = left.right;
        if(node.left != null) {
            node.left.parent = node;
        }
        // 将y的父节点变成x父节点
        left.parent = node.parent;
        // 如果父节点为空  则将root节点重置
        if(left.parent == null) {
            root = left;
        } else {
            // 判断x是父节点的左子树
            if(node == node.parent.left) {
                node.parent.left = left;
            } else {
                node.parent.right = left;
            }
        }

        // 将y的右子树变成x 并将x的父节点变成y
        left.right = node;
        node.parent = left;
    }

    /**
     * 染色为黑节点
     */
    private void setBlack(Node node) {
        node.red = false;
    }

    /**
     * 染色为红节点
     */
    private void setRed(Node node) {
        node.red = true;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    static class Node<T> {
        Node parent;
        Node left;
        Node right;
        Integer value;
        boolean red;

        Node (Integer value) {
            this.value = value;
            this.red = true;
        }

        Node (Node parent, Node left, Node right, Integer value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
            this.red = true;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Integer getValue() {
            return value;
        }

        public boolean isRed() {
            return red;
        }
    }
}
