def is_open_bracket(s):
    if s=='(' or s=='{' or s=='[':
        return True
    return False
def is_closed_bracket(s):
    if s==')' or s=='}' or s==']':
        return True
    return False
def is_star(s):
    if s=='*':
        return True
    return False

if __name__ == "__main__":
    l =[]
    dic={"{":"}","[":"]","(":")"}
    s="{**(**{**[**]})}"
    no_of_star=0
    total_star =0
    yes_pair ,no_pair =0,0
    for c in s:
        # print(c,l)
        # print(dic)
        if is_open_bracket(c):
            l.append(c)
            # print(c,l)
            if no_of_star!=0:
                l.append(str(no_of_star))
                no_of_star=0
        elif is_star(c):
            no_of_star+=1
        elif is_closed_bracket(c):

            if no_of_star!=0:
                l.append(str(no_of_star))
                no_of_star =0
            top_value =l.pop()
            if top_value.isdigit():
                # print(top_value)
                total_star=int(top_value)
                if l.pop()==dic[c]:
                    if total_star%2==0:
                        yes_pair+=1
                    else:
                        no_pair+=1
                else:
                    no_pair+=1
                
            else:
                if top_value==dic[c]:
                    if total_star%2==0:
                        yes_pair+=1
                    else:
                        no_pair+=1
                else:
                    no_pair+=1
    if l==[] and no_pair==0:
        print('Yes '+str(yes_pair))
    else:
        print('No '+str(no_pair))