//36% 틀림
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		
		Stack<Data> st = new Stack<>();
		boolean ispossible =true;
		String[] express = new String[c.length];
		for (int i = 0; i < c.length; i++) {
			express[i] = new String();
		}
		
		for (int i = 0; i < c.length; i++) {
			if(st.isEmpty()) {
				st.push(new Data(c[i],i));
			}else {
				if(st.peek().c=='(' && c[i]==')') {
					if(st.peek().i == i-1) {
						express[st.peek().i]="+";
						express[i]="2";
					}
					else {
						express[st.peek().i]="+(";
						express[i]=")*2";
					}
					st.pop();
				}else if(st.peek().c=='[' && c[i]==']') {
					if(st.peek().i == i-1) {
						express[st.peek().i]="+";
						express[i]="3";
					}
					else {
						express[st.peek().i]="+(";
						express[i]=")*3";
					}
						st.pop();
				}else
					st.push(new Data(c[i],i));
			}
		}
		if(st.isEmpty())
			System.out.println(stoi(String.join(" ", express)));
		else
			System.out.println("0");
	}
	public static int stoi(String s) throws ScriptException {
		
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
		return ((Number)engine.eval(s)).intValue();
	}
}
class Data{
	char c;
	int i;
	Data(char c,int i){
		this.c=c;
		this.i=i;
	}
}

//구글링 참고
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] c = br.readLine().toCharArray();
        Stack<Character> st = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(') { 
                st.push(c[i]); 
                value *= 2; //( : 2
            } else if(c[i] == '[') {
                st.push(c[i]); 
                value *= 3; //[ : 3
            } else if(c[i] == ')') {
                if(st.isEmpty() || st.peek() != '(') { 
                    result = 0;
                    break;
                } else if(c[i-1] == '(') {
                    result += value;
                }
                st.pop();
                value /= 2;
            } else if(c[i] == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    result = 0;
                    break;
                } else if (c[i-1] == '[') {
                    result += value;
                }
                st.pop();
                value /= 3;
            }
        }
        if(!st.isEmpty()) sb.append(0).append("\n");
        else sb.append(result).append("\n");
        System.out.println(sb);
	}
}