package dsa.stack;

/**
 * @author vkiprono
 * @created 11/21/23
 */

public class StackImplArray {
    static int[] myStack = new int[5];
    static int top = -1;

    public static void main(String[] args) {

        System.out.println("-------Empty------");
        System.out.println(isEmpty());
        System.out.println("----Push----");
        System.out.println(push(4));
        System.out.println(push(434));
        System.out.println(push(423));
        System.out.println(push(42));
        System.out.println(push(41));
        System.out.println("-----POP----------");
        System.out.println("isEmpty?" + isEmpty());
        System.out.println("isFull?" + isFull());
        display();
        System.out.println();
        System.out.println("Remove element");
        System.out.println(pop());
        System.out.println("Top element is" + peek());


    }
    //Push
    public static int push(int data){
        if (!isFull()){
            myStack[++top] = data;
        }
        else{
            System.out.println("The stack is full!!");
        }
        return top;
    }

    //pop
    public static int pop(){
        int topElement = myStack[top];
        if (isEmpty()){
            System.out.println("The stack is empty");
        }
        myStack[top] = -1;
        top--;
        return topElement;
    }

    //isFull
    public static boolean isFull(){
        return  (top == myStack.length-1);
    }

    //isEmpty()
    public static boolean isEmpty(){
        return (top == -1);
    }

    //peek
    public static int peek(){
        if (isEmpty()){
            System.out.println("The stack is empty!!");
            return -1;
        }
        return myStack[top];
    }

    public static void display() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.print(myStack[i] + "->");
            }
        }
    }

}
