package stack.imp;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/

public class DecodeString {

  // t: O(n), s: O(n)
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();

    StringBuilder reps = new StringBuilder();
    Stack<Node> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {

        reps.append(c);

      } else if (c == '[') {

        StringBuilder content = new StringBuilder();
        Node node = new Node(reps, content);
        stk.push(node);
        reps.setLength(0);

      } else if (c == ']') {

        Node node = stk.pop();
        StringBuilder content = node.content;
        String repeated = content.toString().repeat(node.rep);
        node.content = new StringBuilder(repeated);

        if (stk.isEmpty()) {
          sb.append(node.content);
        } else {
          stk.peek().content.append(node.content);
        }

      } else {

        if (stk.isEmpty()) {
          sb.append(c);
        } else {
          stk.peek().content.append(c);
        }
      }
    }

    return sb.toString();
  }

  static class Node {
    int rep;
    StringBuilder content;

    public Node(StringBuilder rep, StringBuilder content) {
      this.rep = Integer.parseInt(rep.toString());
      this.content = content;
    }
  }
}
