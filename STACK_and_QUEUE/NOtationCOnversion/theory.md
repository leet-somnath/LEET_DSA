infix to postfix

1. if character is operand add it to ans
2. if character is operator and has max priority then stack top character then insert it or stack is empty insert it
3. if character is open bracket or low priroty or equal priority than top stack character then replace it and add top character to ans
4. if character is close then pop and add to ans until u get open bracket

infix to prefix

1. reverse the infix
2. convert into postfix:-
   0.if character is operand add it to ans
   1. if character is operator and has max priority or equal priority then stack top character then insert it or stack is empty insert it
   2. if character is open bracket or low priroty or equal priority than top stack character then replace it and add top character to ans
   3. if character is close then pop and add to ans until u get open bracket
3. reverese the postfix
