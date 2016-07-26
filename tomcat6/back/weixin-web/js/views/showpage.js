/**
* @Author:Wyan
* @Date:2010/9/16
*/
var Class = {
	create: function() {
		return function() { this.initialize.apply(this, arguments); }
	}
}
var ShowPage = Class.create();
ShowPage.prototype = {
	//容器对象，滑块
	initialize: function() {
		this.url="";
		this.re="";
		this.CurrentPagere=1;
		this.FirstPageUrl="";
		this.PrevPageUrl="";
		this.NextPageUrl="";
		this.LastPageUrl="";
		this.CurrPage=1;
		this.PageCount=0;
		this.prevpage=0;
		this.nextpage=0;
		this.PageStart=0;
		this.PageEnd=0;
		this.ipage=0;
	},
	CheckNum:function(str,num){
		str=""+str;
		if (str.length>=1) {
			mynum=parseInt(str);
			if (isNaN(mynum)) {
				mynum=num;
			}
		}
		else {
			mynum=num;
		}
		return (mynum);
	},
	CheckPage:function(iPageCount){
		this.url = this.url+'/page_';
		this.url = this.url.replace("?&","?");
		this.url = this.url.replace("&&","&");
		this.ipage = document.iform.Page.value;
		this.ipage = this.CheckNum(this.ipage,1);
		if (this.ipage>iPageCount)	 {
			this.ipage=iPageCount;
		}
		else if (this.ipage<1)	 {
			this.ipage=1;
		}
		else {
			this.ipage=this.ipage;
		}
		document.iform.action = this.url+this.ipage;
		document.iform.submit();
	},
	show:function(Tabstart,Tabend,CurrPageFont1,CurrPageFont2,PageCountFont1,PageCountFont2,PrePageFont1,PrePageFont2,RecCountFont1,RecCountFont2,FirstFont,PrevFont,NextFont,LastFont,Jump,PageNumFont1,PageNumFont2,PageNumFont3,PageNumFont4,LinkFont1,LinkFont2,LinkFont3,LinkFont4,RecCount,RecPerPage,PageNum,returnType){
		if (RecCount%RecPerPage==0) {
			this.PageCount=RecCount/RecPerPage;
		}
		else {
			this.PageCount=(parseInt(RecCount/RecPerPage)+1);
		}
		if (this.PageCount<=1) {
			this.PageCount=1;
		}
		if(this.CurrPage>this.PageCount)
		{
			window.location.href = this.url+"page_"+this.PageCount;
			return;
		}
		this.prevpage = parseInt(this.CurrPage-1);
		if (this.prevpage<1) {
			this.prevpage=1;
		}
		this.nextpage = parseInt(this.CurrPage+1);
		if (this.nextpage>this.PageCount) {
			this.nextpage = this.PageCount;
		}
		if (this.CurrPage<=1&&this.PageCount==1) {
			this.CurrPage=1;
			this.FirstPageUrl="&nbsp;"+LinkFont3+FirstFont+LinkFont4+"&nbsp;";
			this.PrevPageUrl="&nbsp;"+LinkFont3+PrevFont+LinkFont4+"&nbsp;";
			this.NextPageUrl="&nbsp;"+LinkFont3+NextFont+LinkFont4+"&nbsp;";
			this.LastPageUrl="&nbsp;"+LinkFont3+LastFont+LinkFont4+"&nbsp;";
		}
		else if (this.CurrPage<=1) {
			this.CurrPage=1;
			this.FirstPageUrl="&nbsp;"+LinkFont3+FirstFont+LinkFont4+"&nbsp;";
			this.PrevPageUrl="&nbsp;"+LinkFont3+PrevFont+LinkFont4+"&nbsp;";
			this.NextPageUrl="&nbsp;<a href=\"javascript:;\" page=\""+this.nextpage+"\">"+LinkFont1+NextFont+LinkFont2+"</a>&nbsp;";
			this.LastPageUrl="&nbsp;<a href=\"javascript:;\" page=\""+this.PageCount+"\">"+LinkFont1+LastFont+LinkFont2+"</a>&nbsp;";
		}
		else if (this.CurrPage>=this.PageCount) {
			this.CurrPage = this.PageCount;
			this.FirstPageUrl="&nbsp;<a href=\"javascript:;\" page=\"1\">"+LinkFont1+FirstFont+LinkFont2+"</a>&nbsp;";
			this.PrevPageUrl="&nbsp;<a href=\"javascript:;\" page=\""+this.prevpage+"\">"+LinkFont1+PrevFont+LinkFont2+"</a>&nbsp;";
			this.NextPageUrl="&nbsp;"+LinkFont3+NextFont+LinkFont4+"&nbsp;";
			this.LastPageUrl="&nbsp;"+LinkFont3+LastFont+LinkFont4+"&nbsp;";
		}
		else {
			this.CurrPage = this.CurrPage;
			this.FirstPageUrl="&nbsp;<a href=\"javascript:;\" page=\"1\">"+LinkFont1+FirstFont+LinkFont2+"</a>&nbsp;";
			this.PrevPageUrl="&nbsp;<a href=\"javascript:;\" page=\""+this.prevpage+"\">"+LinkFont1+PrevFont+LinkFont2+"</a>&nbsp;";
			this.NextPageUrl="&nbsp;<a href=\"javascript:;\" page=\""+this.nextpage+"\">"+LinkFont1+NextFont+LinkFont2+"</a>&nbsp;";
			this.LastPageUrl="&nbsp;<a href=\"javascript:;\" page=\""+this.PageCount+"\">"+LinkFont1+LastFont+LinkFont2+"</a>&nbsp;";
		}
		if (this.CurrPage-PageNum<=1) {
			this.PageStart=1;
		}
		else {
			this.PageStart = this.CurrPage-PageNum;
		}
		if (this.CurrPage+PageNum>=this.PageCount) {
			this.PageEnd = this.PageCount;
		}
		else {
			this.PageEnd = this.CurrPage+PageNum;
		}
		var returnStr = '';
		returnStr += "<FORM method=\"post\" name=\"iform\" id=\"pageform\" action=\""+this.url+"\" onSubmit=\"return CheckPage("+this.PageCount+")\" recount=\""+RecCount+"\">"+Tabstart;
		returnStr += CurrPageFont1+this.CurrPage+CurrPageFont2+PageCountFont1+this.PageCount+PageCountFont2+PrePageFont1;
		returnStr += RecPerPage+PrePageFont2+RecCountFont1+RecCount+RecCountFont2;
		if(parseInt(RecCount)>0 && parseInt(RecCount) > parseInt(RecPerPage))
		{
			returnStr += this.FirstPageUrl+this.PrevPageUrl;
			for (i=this.PageStart;i<=this.PageEnd;i++) {
				if (i==this.CurrPage) {
					returnStr += "&nbsp;<font class=\"fontbold fontblue\">"+PageNumFont3+i+PageNumFont4+"</font>&nbsp;";
				}
				else {
					returnStr += "&nbsp;<a href=\"javascript:;\" page=\""+i+"\">"+PageNumFont1+i+PageNumFont2+"</a>&nbsp;";
				}
			}
			returnStr += this.NextPageUrl+this.LastPageUrl+Jump;
		}
		returnStr += "</FORM>";
		if(typeof(returnType)!="undefined")
		{
			document.write(returnStr);
			alert(1);
		}
		else
		{
			return returnStr;
			alert(2);
		}
	}
};
