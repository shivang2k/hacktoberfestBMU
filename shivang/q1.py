def solution(s):
    dic = {'{' : '}', '[' : ']', '(' : ')'}

    lis = []

    for i in s:
        if i in dic.keys():
            lis.append(i)
        else:
            if len(lis) <= 0:
                print("false")
                exit(0)
            a = lis.pop()
            if dic[a] != i:
                print("false")
                exit(0)

    print("true")


solution("[][]{}[[[]]]")