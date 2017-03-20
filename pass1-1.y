%{
#include<string.h>
#include "includef.h"
FILE* f;
char* ch;
int flag=0;
int cc=0;
extern FILE* yyin;
extern FILE* yyout;
char final[100];
char call[100];
int q;
%}

%union {
  int val;
  char str[40];
}

%token MACRO ID NL SPACE CH MEND AMP COMMA DIGIT
%type <str> ID
%type <str> ARG
%type <str> AR
%type <str> DEF
%type <str> SPACE
%type <str> CH
%type <str> COMMA
%type <str> NL
%type <str> MEND
%type <str> DIGIT
%%
I: S                      
 | S I 
 | S BODY
 ;                    
S: ID SPACE MACRO SPACE ARG NL DEF{
			Namtab *sym = search_name($1);
			if(sym==NULL)
			{ 	
       
        insert_name($1,cc++);
			//printf("Inserting name %d\n",cc);
			//	f=fopen($1,"a+");
			//	printf("%s",$7);
			}
			else
			printf("Duplicate\n");
                       // printf("matched");
			}
 | ID SPACE MACRO NL DEF{
                        Namtab *sym = search_name($1);
                        if(sym==NULL)
                        {      
                              insert_name($1,cc++);
                              //printf("Inserting name %d\n",cc);
                        }
                        else
                        printf("Duplicate\n");
                       // printf("matched");
                        }


ARG: AR        {
		//		insert_arg($1,cc);
			//	printf("Inserting arguments %d",cc);
		
                       }
   | AR COMMA ARG
   

AR: AMP ID           {
			insert_arg($2,cc);
                     //printf("Inserting arg %d\n",cc);
			}

DEF: CH DEF          {//fprintf(f,$1);
			//printf("1\n");printf("%s",$$);//printf("1a:%s is $1\n",$1);printf("1b:%s is $2\n",$2);
			}       
   | SPACE DEF        {//printf("2\n");printf("%s",$$);//printf("2a:%s is $1\n",$1);printf("2b:%s is $2\n",$2);
			
			}      
   | COMMA DEF        {//printf("3\n");printf("%s",$$);//printf("3a:%s is $1\n",$1);printf("3b:%s is $2\n",$2);
			}        
   | NL DEF           {//printf("4\n");printf("%s",$$);//printf("4a:%s is $1\n",$1);printf("4b:%s is $2\n",$2);
			}        
   | MEND NL          {//printf("5\n");
			//printf("5a:%s is $1\n",$1);printf("5b:%s is $2\n",$2);
		//	strcat($1,$2); 
			//printf("%s",$$);	
			}            
   | ID DEF           {//printf("6\n");printf("%s",$$);
			//printf("6a:%s is $1\n",$1);printf("6b:%s is $2\n",$2);//strcat($1,$2); strcpy($$,$1);
			} 
BODY : CH BODY {/*fprintf(yyout,"%s",$1);*/strcat(final,$1);strcat(call,$1);}
| SPACE BODY {/*fprintf(yyout,"%s",$1);*/strcat(final,$1);strcat(call,$1);}
|COMMA BODY {/*fprintf(yyout,"%s",$1);*/strcat(final,$1);strcat(call,$1);}
|NL BODY {/*fprintf(yyout,"%s",$1);*/strcat(final,$1);strcat(call,$1);}
|DIGIT BODY {strcat(final,$1);strcat(call,$1);}
|ID BODY {/*fprintf(yyout,"%s",$1);*/
						Namtab *sym = search_name($1);
    /*                    if(sym!=NULL) {printf("Found\n");
                        printf("Name: %s\t No: %d\n",sym->mname,sym->no);}*/
			strcat(final,$1);
			strcat(call,$1);
			if(sym!=NULL) 
			{	int i;
			//	printf("%d\n",strlen(final));
			//	printf("%s\n",final);
				 Argtab* as=(sym->Ahead);
		//		Argtab* as=arghead[sym->no];
//				print_argtab(as);
				
		                	
				//print_argtab(as);
				int j=0;
				int k,m;
				char d[20];
				for(i=1; i<strlen(call);)
				{
			   		 if(call[i]==',')
		            			{ 
							//as=as->link; //as->aval=d;
						//	printf("%s\n",as->aname);
							d[j]='\0';
							strcpy(as->aval,d);
							as=as->link;
							i=i+2;
							//d=NULL;
							for(m=0;m<=j;m++)
							d[m]='\0';
							d[0]='\0';
							j=0;
						}
                         if(call[i]!=' ')
			    		{
						//strcat(d,call[i]);
						d[j]=call[i];
						
						i++;j++;
                           		 }
					else
					{
						i++;
						if(call[i]!=',')
							break;
					}
						
				 
				}	
				strcpy(as->aval,d);
				//printf("%s\n",as->aname);
				for(q=0;q<strlen(call);q++)
				call[q]='\0';
			}
			for(q=0;q<strlen(call);q++)
				call[q]='\0';
	}
|
;			               
%%
void swap(char* str, int i, int j){
    char t = str[i];
    str[i] = str[j];
    str[j] = t;
}

void reverse_string(char* str, int length){
    int i;
    for(i=0; i<length/2; i++){
        swap(str, i, length-i-1);
    }
}
void reverse_words(char* str){

    int l = strlen(str);
    //Reverse string
    reverse_string(str,strlen(str));
    int p=0;
    //Find word boundaries and reverse word by word
    int i;
    for(i=0; i<l; i++){
        if(str[i] == ' '){
            reverse_string(&str[p], i-p);
            p=i+1;
        }
    }
    //Finally reverse the last word.
    reverse_string(&str[p], l-p);
}
void reverse_sentence(char* str){
    int l = strlen(str);
    reverse_string(str,strlen(str));
    int p=0;
    //Find word boundaries and reverse word by word
    int i;
    for(i=0; i<l; i++){
        if(str[i] == '\n'){
            reverse_string(&str[p], i-p);
            p=i+1;
        }
    }
    //Finally reverse the last word.
    reverse_string(&str[p], l-p);
}
void extract(int num)
{
	FILE* f1=fopen("1.txt","r");
	FILE* fn=fopen("f3.txt","a+");
	char ch;
	char x[100];
	int i=0;
	while((ch=getc(f1))!=EOF)
	{	
		if(ch==(char)(num+48))
		{

			if((ch=getc(f1))=='-')
				while((ch=getc(f1))=='-');
			num++;
			while((ch=getc(f1))!='\n');
			ch=getc(f1);
			while(ch!=EOF)
			{
				
			if(ch!=(char)(num+48))
				{fprintf(fn,"%c",ch);
					ch=getc(f1);
				}	
				else
				{
					if((ch=getc(f1))=='-')
						{						fclose(fn);
						return;

						}
						else
						fprintf(fn,"%c\n",ch);	
				}

			}
			
		}
	}
	fclose(fn);
	return;
	
}
void expand()
{
	FILE* f2=fopen("f2.txt","r");
	FILE* f3;
	f3=fopen("f3.txt","a+");
	//, fprintf(f3,"Working\n");
	char s1[100];
	int flag=0;
	int m,k=0;
	char ch;
	while((ch=getc(f2))!=EOF)
	{
		if(ch==' ')
		{
		fprintf(f3,"%s",s1);
		fprintf(f3," ");
		for(m=0;m<=strlen(s1);m++)
		s1[m]='\0';
		k=0;
		}
		else if(ch==',')
    {
    fprintf(f3,"%s",s1);
    fprintf(f3,",");
    for(m=0;m<=strlen(s1);m++)
    s1[m]='\0';
    k=0;
    }
		else if(ch=='\n')
		{
		fprintf(f3,"%s",s1);
		fprintf(f3,"\n");
		for(m=0;m<=strlen(s1);m++)
		s1[m]='\0';
		k=0;
		}
		else
		{
			s1[k++]=ch;
			s1[k]='\0';
			Namtab *sym = search_name(s1);
			if(sym!=NULL)
			{
				while((ch=getc(f2))!='\n');
				fclose(f3);
				f3=fopen("f3.txt","a+");
				extract(sym->no);
				k=0;
				for(m=0;m<=strlen(s1);m++)
    				s1[m]='\0';

			}

		}
	}
}  

int main()
{
  int i;
  for(i=0;i<10;i++)
    arghead[i]=NULL;
FILE* out;
yyin=fopen("f1.txt","r");
yyout=fopen("f2.txt","a+");

 yyparse();
print_namtab();

reverse_sentence(final);
 char *token;
token = strtok(final,"\n");

while( token != NULL ) 
   {
   reverse_words(token);
      fprintf(yyout,"%s",token);
      fprintf(yyout,"\n");
      token = strtok(NULL,"\n");
   }
fclose(yyout);
 printf("Valid\n");
 expand();
 call_namtab();
 remover();
 return 1;
}
int yyerror()
{
 printf("Invalid\n");
 exit(0);
}


