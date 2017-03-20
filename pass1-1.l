%{
#include "y.tab.h"
int fl=0;
int count=-1;
FILE* fd;
//fd=fopen("1.txt","w");
char final[100];
%}
%%
"MACRO" {fl=1; count++;
				fd=fopen("1.txt","a+");
				fprintf(fd,"%d",count);
				fprintf(fd,"----------------\n");return MACRO;}
"MEND" {fl=0; 
			fd=fopen("1.txt","a+");
				fprintf(fd,"\0");
				 strcpy(yylval.str,yytext); return MEND;}
[a-zA-Z_][a-zA-Z0-9_]* {
				if(fl==1)
				{
				fd=fopen("1.txt","a+");
				fprintf(fd,"%s",yytext);
				}
				 strcpy(yylval.str,yytext); return ID;
			}
[0-9]+ {
		if(fl==1)
                                {
                                fd=fopen("1.txt","a+");
                                fprintf(fd,"%s",yytext);
                                }

                strcpy(yylval.str,yytext);
		return DIGIT;
	}
\n {
		 if(fl==1)
                                {
                                fd=fopen("1.txt","a+");
                                fprintf(fd,"%s",yytext); 
                                } 

		strcpy(yylval.str,yytext); return NL;
	}
[&] {		
		 if(fl==1)
                                {
                                fd=fopen("1.txt","a+");
                                fprintf(fd,"%s",yytext); 
                                } 
		strcpy(yylval.str,yytext); return AMP;
	}
[,] {		
		 if(fl==1)
                                {
                                fd=fopen("1.txt","a+");
                                fprintf(fd,"%s",yytext); 
                                } 
		strcpy(yylval.str,yytext); return COMMA;
	}
[ ] {
		 if(fl==1)
                                {
                                fd=fopen("1.txt","a+");
                                fprintf(fd,"%s",yytext); 
                                } 
		strcpy(yylval.str,yytext); return SPACE;
	}
. {
		 if(fl==1)
                                {
                                fd=fopen("1.txt","a+");
                                fprintf(fd,"%s",yytext); 
                                } 
		strcpy(yylval.str,yytext); return CH;
	}

%%
int yywrap()
{
 return 1;
}


