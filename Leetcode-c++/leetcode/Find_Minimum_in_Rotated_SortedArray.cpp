#include "stdafx.h"
#include <vector>
#include <iostream>


using namespace std;

class Fmirsa {
public:
	int findMin(vector<int> &num) {
		int length(num.size());
		int mid(0), start = 0, end = length - 1;
		if (num[start] <= num[end]){
			return num[start];
		}
		while (start + 1 < end){
			mid = (start + end) / 2;
			if (num[mid] < num[start]){
				end = mid;
			}
			else{
				start = mid;
			}
		}
		return num[start] < num[end] ? num[start] : num[end];

	}
};


int _tmain(int argc, _TCHAR* argv[])
{
	Fmirsa f;
	vector<int> v1 = { 0,1,2,4,5,6,7 };
	vector<int> v2 = { 4, 5, 6, 7 ,0, 1, 2};
	vector<int> v3 = { 4, 5, 6};
	cout << f.findMin(v1) << endl;
	cout << f.findMin(v2) << endl;
	cout << f.findMin(v3) << endl;
	return 0;
}