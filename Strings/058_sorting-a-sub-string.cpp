#include<bits/stdc++.h>
using namespace std;

string rearrange(string s, int n, int m){
	sort(s.begin()+n,s.begin()+m +1, greater<char>());
	return s;
}

int main(){
	int t;
	cin>>t;
	while(t--){
		string s;
		cin>>s;
		int n,m;
		cin>>n>>m;
		string answer = rearrange(s,n,m);
		cout<<answer<<endl;
	}
	return 0;
}
