import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class afvink3 {
    private static String sentence;
    static Stack<Character> stack = new Stack<>();

    public void setSentence(String stack) {
        this.sentence = stack;
    }

    public static String getSentence() {
        return sentence;
    }

    public static void main(String[] args) {
        afvink3 st = new afvink3();
        st.setSentence("[{2*3}*(3+1)");
        controle();
    }

    static void controle() {
        System.out.println("Provided sentence: " + getSentence() + "\n");
        boolean err=false;
        // check if all brackets are closed
        for (int i = 0; i < getSentence().length(); i++) {
            try {
                // add brackets to a stack
                if (getSentence().charAt(i) == '(') {
                    stack.push('(');
                }
                else if (getSentence().charAt(i) == '[') {
                    stack.push('[');
                }
                else if (getSentence().charAt(i) == '{') {
                    stack.push('{');
                }
                // check if a stack is empty
                if (!stack.empty()) {
                    // pop brackets is they close
                    if (getSentence().charAt(i) == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            System.out.println("Not a good order of the brackets!");
                        }
                    } else if (getSentence().charAt(i) == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            System.out.println("Not a good order of the brackets!");
                        }
                    } else if (getSentence().charAt(i) == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            System.out.println("Not a good order of the brackets!");
                        }
                    }
                }
                // if stack is empty
                else{
                    if (getSentence().charAt(i) == ')') {
                        System.out.println("You forgot to add an open bracket '('");
                        err = true;
                        break;
                    }
                    else if (getSentence().charAt(i) == ']') {
                        System.out.println("You forgot to add an open bracket '['");
                        err = true;
                        break;
                    }
                    else if (getSentence().charAt(i) == '}') {
                        System.out.println("You forgot to add an open bracket '{'");
                        err = true;
                        break;
                    }
                }
            }
            catch (EmptyStackException e){
                System.out.println("Error, you tried to pop an empty stack!");
                err = true;
            }
        }if (stack.isEmpty()&&!err) {
            System.out.println("No errors found.");
        }else if (!stack.isEmpty()&&!err){
            System.out.println("You forgot to close the bracket: "+stack.peek());
        }
    }
}
