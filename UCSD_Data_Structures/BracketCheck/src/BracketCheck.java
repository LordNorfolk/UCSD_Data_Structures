/*
* UCSD Data Structures hw 1
* author: Lord Norfolk
*
* Goal: Ensure all open brackets have a matching closing bracket
*
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;


public class BracketCheck {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket bracbrac = new Bracket(next, position);
                opening_brackets_stack.push(bracbrac);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                Bracket ketket = new Bracket(next,  position);

                if (opening_brackets_stack.empty() == true) {

                    opening_brackets_stack.push(ketket);
                    break;
                }

                else if (opening_brackets_stack.peek().Match(ketket.type)) {

                    opening_brackets_stack.pop();

                }

                else {

                    opening_brackets_stack.push(ketket);
                    break;
                }
            }
        }

        if (opening_brackets_stack.empty() == true) {

            System.out.print("Success");

        }

        else {

            System.out.print(opening_brackets_stack.peek().position + 1);

        }
    }
}


class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}