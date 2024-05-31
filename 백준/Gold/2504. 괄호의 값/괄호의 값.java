import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String List = sc.nextLine();
		
		Stack<Character> stack = new Stack<>();
        
		int result = 0;
		int temp = 1; //임시 값은 괄호가 여는 괄호일 경우 2로, 여는 대괄호일 경우 3으로 초기화
		boolean isValid = true; //올바른 괄호 쌍이 입력되었는지 여부 확인
		
		for(int i=0; i<List.length(); i++) {
			
			/*여는 괄호인 경우
			- 해당 괄호를 스택에 push
			- temp *2 또는 *3하기
			*/
			if(List.charAt(i) == '(') {
				stack.push(List.charAt(i));
				temp *= 2;
			}
			if(List.charAt(i) == '[') {
				stack.push(List.charAt(i));
				temp *= 3;
			}
			
			
			/*닫는 괄호인 경우
			 - 스택이 비어있고  + 스택 맨 위에 있는 괄호와 현재 괄호가 매치되지 않는다면(peek로 확인)
			 -> 올바르지 않은 문자열로 보고 빠져나가기
			 */
			if(List.charAt(i) == ')' && (stack.isEmpty() || stack.peek() != '(')) {
				isValid = false;
				break;
			}
			if(List.charAt(i) == ']' && (stack.isEmpty() || stack.peek() != '[')) {
				isValid = false;
				break;
			}
			
			
			
			/*올바른 괄호열이 성립되는 경우
			 - 이전에 여는 괄호가 같은 종류의 괄호였는지 확인 -> 해당 괄호에 할당된 값을 결과에 더하기
			 - 스택에서 괄호를 pop
			 - 임시 값 temp를 해당 괄호의 규칙에 맞게 /=2 또는 /=3
			*/
			if(List.charAt(i) == ')') {
				if(List.charAt(i-1) == '(')
					result += temp;
				stack.pop();
				temp /= 2;
			}
			if(List.charAt(i) == ']') {
				if(List.charAt(i-1) == '[')
					result += temp;
				stack.pop();
				temp /= 3;
			}
		}
		
		if(!isValid || !stack.isEmpty()) { //!(올바른 괄호열) 즉, 올바르지 않은 괄호열이거나 스택이 비어있지 않은 경우 결과는 0 출력
			result = 0;
		}
		System.out.println(result);
	}
}