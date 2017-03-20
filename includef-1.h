#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct argtab
{
        char aname[20];
        char aval[20];
        struct argtab *link;
};

typedef struct argtab Argtab;
Argtab *arghead[10];

struct namtab
{
   char mname[20];
   char* beg;
   char* end;
   int no;
   struct namtab *link;
   Argtab* Ahead;
};

typedef struct namtab Namtab;
Namtab *head=NULL;

Namtab *search_name(char label[])
{
	if(head == NULL)
  		return NULL;
  
	Namtab *cur = head;
	while(cur&&strcmp(cur->mname,label)!=0)
   		cur=cur->link;
  	
  	return cur;
}




void insert_name(char name[],int i)
{
	Namtab *temp;
	temp=(Namtab *)malloc(sizeof(Namtab));
	if(head==NULL)
                temp->Ahead=NULL;
	strcpy(temp->mname,name);
//        printf("%s\n",temp->mname);
  temp->no=i;
	temp->link=head;
	temp->Ahead=arghead[i];
        head=temp;
  
}

void insert_arg(char name[],int i)
{
        Argtab *temp;
        temp=(Argtab *)malloc(sizeof(Argtab));
        strcpy(temp->aname,name);
//        printf("%s\n",temp->mname);
        temp->link=arghead[i];
        arghead[i]=temp;
}


void print_argtab(Argtab *a)
{
  if(a == NULL)
  {          printf("empty argtab");    return;
  }
 Argtab *cur;
 cur=a;
// printf("Contents of Argument Table:\n");
 while(cur!=NULL)
 {
   printf("\tName:%s   Value:%s\n",cur->aname,cur->aval);
   cur=cur->link;
 }
}




void print_namtab()
{
  if(head == NULL)
  {          printf("Empty NAMTAB");    return;
  }
 Namtab *cur;
 cur=head;
 printf("Contents of Name Table:\n");
 while(cur!=NULL)
 {
   printf("%s %d ",cur->mname,cur->no);
   printf("\nAssociated arg tab: ");
   print_argtab(cur->Ahead); 
   cur=cur->link;
 }
}
void replacer(char* x,char* y) // function for count no of words,lines & characters.
{
   FILE *f2,*f3;
   f2=fopen("f3.txt","r");
   f3=fopen("f3.txt","r+");
   fflush(f3);
   int m,k=0,flag=0;
   char s1[100];
  char ch;
  while((ch=getc(f2))!=EOF)
  {
    if(ch==' ')
    {
      //fflush(f3);
   fprintf(f3,"%s",s1);
   //printf("1.%s ",s1);
    fprintf(f3," ");
    for(m=0;m<=strlen(s1);m++)
    {//printf("1.%c\n",s1[m]);
    s1[m]='\0';
    }
    k=0;
    }
    else if(ch==',')
    {
      //fflush(f3);
    fprintf(f3,"%s",s1);
    //printf("2.%s,",s1);
    fprintf(f3,",");
    for(m=0;m<=strlen(s1);m++)
    {//printf("2.%c\n",s1[m]);
    s1[m]='\0';
    }
    k=0;
    }

    else if(ch=='\n')
    {
    
    fprintf(f3,"%s",s1);
    fprintf(f3,"\n");
    memset(s1,0,strlen(s1));
    k=0;
    flag=0;
    }
  
    else
    {
      s1[k++]=ch;
      s1[k]='\0';
      
      if(strcmp(s1,x)==0)
      {
          
         fprintf(f3,"%s",y);
         fprintf(f3,"\0");
         //printf("4.%s",y);
         
        flag=1;
        k=0;
        for(m=0;m<=strlen(s1);m++)
          s1[m]='\0';
         

      }


    }
  }
    fclose(f2);
  fclose(f3); 

}
void call_argtab(Argtab *a)
{
  if(a == NULL)
  {        return;
  }
 Argtab *cur;
 cur=a;
// printf("Contents of Argument Table:\n");
 while(cur!=NULL)
 {
   replacer(cur->aname,cur->aval);
   cur=cur->link;
 }
}




void call_namtab()
{
  if(head == NULL)
  {          return;
  }
 Namtab *cur;
 cur=head;
 while(cur!=NULL)
 {
   call_argtab(cur->Ahead); 
   cur=cur->link;
 }
}
void remover()
{
  FILE *file, *fn;
char *line = NULL;
size_t len = 0;
char read;
int i=0;
file=fopen("f3.txt", "r");
fn=fopen("f3.txt","r+");
if (file == NULL)
    return;

while ((read = getline(&line,&len, file)) != -1) {
    printf("%d.Retrieved line of length %d :\n",i,read);
        printf("%s", line);
    if(read!=2)
    {
        fprintf(fn,"%c",(char)1);
      fprintf(fn,"%s",line);
      line[0]='\0';
    }
    i++;
}
fclose(file);
fclose(fn);
  

  
}
