// leetcode.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include "majorityElement.h"
#include <iostream>


int _tmain(int argc, _TCHAR* argv[])
{
	using namespace std;
	Solution s;
	vector<int> num = { 1, 1, 2, 3, 1 ,2,2,2,2,2,2,2};
	cout << s.majorityElement(num) << endl;
	return 0;
}

