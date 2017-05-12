package com.fqy.string;

public class ReverseWords {
	public static void main(String[] args) {
		System.out.println(new ReverseWords().reverseWords(" I will     win the champion!"));
	}

	public String reverseWords(String input) {
		String[] temp = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = temp.length - 1; i >= 0; i--) {
			sb.append(temp[i]);
			if (i > 0)
				sb.append(" ");
		}
		// sb.deleteCharAt(0);

		String result = removeExtraSpace(sb.toString());

		return result;
	}

	public String removeExtraSpace(String str) {
		char[] sequ = str.toCharArray();
		int index = 0;
		boolean flag = false;

		for (int i = 0; i < sequ.length; i++) {
			if (sequ[i] != ' ') {
				sequ[index++] = sequ[i];
				flag = true;
			} else {
				if (flag)
					sequ[index++] = ' ';
				flag = false;
			}
		}
		if (index - 1 >= 0 && index - 1 < sequ.length && sequ[index - 1] == ' ')
			index--;
		return new String(sequ, 0, index);
	}
}
