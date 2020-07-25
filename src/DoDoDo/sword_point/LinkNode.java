package DoDoDo.sword_point;

class LinkNode<T>{
    T data;

    LinkNode next;

    public LinkNode(T data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    public static LinkNode getLink(int length){
        return getLinkAndDataIsInt(length, false);
    }

    public static LinkNode getLinkAndDataIsInt(int length, boolean beginWithZero){
        int begin = beginWithZero==true ? 0 : 1;
        int end = begin==0 ? length-1 : length;
        LinkNode head, pre;
        head = pre = new LinkNode(begin, null);
        for(int i=begin+1; i<=end; i++) {
            LinkNode node = new LinkNode(i, null);
            pre.next = node;
            pre = node;
        }

        return head;
    }

    public static void printLink(LinkNode head){
        LinkNode current = head;
        while(current!=null) {
            System.out.println("node : data is " + current.data);
            if(current.next != null)
                current = current.next;
            else
                current = null;
        }
    }


}