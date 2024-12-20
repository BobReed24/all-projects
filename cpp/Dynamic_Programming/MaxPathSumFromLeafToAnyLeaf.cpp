int solve(Node* root,int& res){
	//base condition
	if(root==NULL)
	return 0;
	
	//Hypothesis
	int l=solve(root->left,res);
	int r=solve(root->right,res);
	
	//induction
	int temp=max(l,r)+root->val;
	int ans=max(temp,l+r+root->val);
	res=max(res,ans);
	
	return temp;
}
