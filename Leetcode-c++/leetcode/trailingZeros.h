#include "stdafx.h"

class Solution {
public:
	int trailingZeroes(int n) {
		int count_five = 0;  
        while ( n > 0) {  
            int k = n / 5;  
            count_five += k;  
            n = k;  
        }  
        return count_five;
	}
};