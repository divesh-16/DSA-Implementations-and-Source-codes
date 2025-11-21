package com.tca;

import java.util.Stack;

import com.tca.util.StackSets;

public class App {

	public static void main(String[] args) 
	{
		StackSets stks = new StackSets(3);
		stks.push(11);
		stks.push(22);
		stks.push(33);
		stks.push(44);
		stks.push(11);
		stks.push(22);
		stks.push(33);
		stks.push(44);
		
		System.out.println(stks);
		
		System.out.println(stks.pop());
		System.out.println(stks.pop());
		System.out.println(stks.pop());
		System.out.println(stks.pop());
		System.out.println(stks.pop());
		System.out.println(stks.pop());
		System.out.println(stks.pop());
		
		
		
		System.out.println(stks);
		
		
		
		/*
		DynamicLinkedListStack stk = new DynamicLinkedListStack();
		
		stk.push(11);
		stk.push(22);
		stk.push(33);
		stk.push(44);
		stk.push(55);
		
		
		System.out.println(stk.size());
		
		System.out.println(stk);
		
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop());
		}
		
		System.out.println(stk.size());
		//System.out.println(stk.capacity());
		
		System.out.println(infixToPostfix("A*B-(C+D)+E"));
		
		*/
		
//		List<Integer> L = Arrays.asList(3,4,6,9,2,1,5,8);
//		System.out.println(L.stream().sorted().toList());
//		
//		Integer a[][] = {{11,22,33,44,55},
//						{66,77,88,99,100}
//						};
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.deepToString(a));
		
		//System.out.println(Character.digit('9',32));
		
//		String s = "1-(     -2)";
//		
//		System.out.println(infixEvalution(s));
		
	}
	
	
	
	public static String infixToPostfix(String str)
	{
		Stack<Character> stk = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length();i++)
		{
			char ch = str.charAt(i);
			
			if(Character.isLetterOrDigit(ch))
			{
				sb.append(ch);
			}
			else if(ch == ')')
			{
				while(stk.peek() != '(' && !stk.isEmpty())
				{
					sb.append(stk.pop());
				}
				
				if(stk.peek() == '(' && !stk.isEmpty())
				{
					stk.pop();	// remove '('
				}
			}
			else
			{
				// Pop and output tokens until:
                // - one of lower priority than t is encountered
                // - OR a '(' is encountered
                // - OR stack becomes empty
				
				while(!stk.isEmpty() && stk.peek() != '(' && precedence(stk.peek()) >= precedence(ch))
				{
					sb.append(stk.pop());
				}
				
				stk.push(ch);
			}
		}
		
		while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.toString();
		
	}
	
	private static int precedence(char ch) 
	{
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
	
	private static int eval(Character op, int left,int right)
	{
		switch(op)
		{
			case '+' :
				return left+right;
			case '-':
				return left-right;
			case '*':
				return left*right;
			case '/':
				return left/right;
		}
		
		return 0;
	}
	
	public static int infixEvalution(String s)
	{
		// Creating 2 stack to store operators and operands.
		
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operator = new Stack<>();
		
		for(int i=0; i<s.length(); i++)
		{
			char token = s.charAt(i);
			
			if(token==' ')
			{
				continue;
			}
			
			// token is Operand, push in operand stack
			if(Character.isDigit(token))
			{
				int num = 0;
				
				// Multi-digit number
				while(i < s.length() && Character.isDigit(s.charAt(i)))
				{
					num = num * 10 + (s.charAt(i)-'0');
					i++;
				}
				
				i--;
				
				operands.push(num);
			}
			else if(token == '(')
			{
				operator.push(token);
			}
			else if(token == ')')
			{
				while(!operator.isEmpty() && operator.peek()!='(')
				{
					int left = 0;
					int right = 0;
					if(!operands.isEmpty())
					{
						right = operands.pop();
					}
					
					if(!operands.isEmpty())
					{
						left = operands.pop();
					}
					
					
					char op = operator.pop();
					
					operands.push(eval(op,left,right));
				}
				
				// popping '('
				operator.pop();
			}
			else
			{
				// token is operator
				
				while(!operator.isEmpty() && precedence(operator.peek()) >= precedence(token))
				{
					int left = 0;
					int right = 0;
					if(!operands.isEmpty())
					{
						right = operands.pop();
					}
					
					if(!operands.isEmpty())
					{
						left = operands.pop();
					}
					
					char op = operator.pop();
					
					operands.push(eval(op,left,right));
				}
				
				operator.push(token);
			}
		}
		
		while(!operator.isEmpty())
		{
			int left = 0;
			int right = 0;
			if(!operands.isEmpty())
			{
				right = operands.pop();
			}
			
			if(!operands.isEmpty())
			{
				left = operands.pop();
			}
			
			char op = operator.pop();
			
			operands.push(eval(op,left,right));
		}
		
		return operands.pop();
	}

}
