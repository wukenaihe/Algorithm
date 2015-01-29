#include "stdafx.h"
#include <vector>

using namespace std;
class Solution {
public:
	int majorityElement(vector<int> &num) {
		int number = 0;
		int n;
		for (vector<int>::iterator it = num.begin(); it != num.end(); ++it){
			if (!number){
				n = *it;
				number = 1;
			}
			else if (n != *it){
				number--;
			}
			else{
				number++;
			}
		}
		return n;
	}
};