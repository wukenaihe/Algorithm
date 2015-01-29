import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		if(s.length()<4){
			return new ArrayList<String>();
		}
		List<String> result = restore(s, 4);
		return result;
	}

	public List<String> restore(String s, int length) {
		if (s.length() <= 0) {
			return null;
		}
		if (length == 1 && s.length() > 3) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		if (length == 1) {
			if (s.length() > 1 && s.charAt(0) == '0') {
				return null;
			}
			if (s.length() == 3 && (!(s.charAt(0) == '1' || s.charAt(0) == '2')||Integer.valueOf(s)>255)) {
				return null;
			}
			list.add(s);
			return list;
		} else {
			if (s.length() > 0) {
				String s1 = s.substring(0, 1);
				List<String> ss1 = restore(s.substring(1), length - 1);
				append(s1, ss1, list);
			}

			if (s.length() > 1 && s.charAt(0) != '0') {
				String s2 = s.substring(0, 2);
				List<String> ss2 = restore(s.substring(2), length - 1);
				append(s2, ss2, list);
			}

			if (s.length() > 2 && (s.charAt(0) == '1' || s.charAt(0) == '2')) {
				String s3 = s.substring(0, 3);
				if (Integer.valueOf(s3) <= 255) {
					List<String> ss3 = restore(s.substring(3), length - 1);
					append(s3, ss3, list);
				}
			}
		}
		return list;
	}

	private void append(String s, List<String> list, List<String> result) {
		if (list == null) {
			return;
		}
		for (String string : list) {
			String s1 = s + "." + string;
			result.add(s1);
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses r = new RestoreIPAddresses();
		System.out.println(r.restoreIpAddresses("172162541"));
		System.out.println(r.restoreIpAddresses("000256"));
		System.out.println(r.restoreIpAddresses("0000"));
	}
}
