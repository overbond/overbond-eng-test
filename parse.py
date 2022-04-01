import pandas as pd
import matplotlib.pyplot as plt

dict = {"01": "Jan", "02": "Feb", "03": "Mar", "04": "Apr", "05": "May"
    , "06": "Jun", "07": "Jul", "08": "Aug", "09": "Sep", "10": "Oct"
    , "11": "Nov", "12": "Dec"}


def parse():
    f = open("XICE_Bond_Close2.tip", "r+", encoding='utf-8')
    i = 0
    str = ""
    for x in f.readlines():
        arr = x.split(';')
        for y in arr:
            if "DIs" in y and "B" not in y:
                dat = y.replace("DIs", "")
                str += dat + "D;"
            elif "BPr" in y:
                num = y.replace("BPr", "")
                str += num + "B;"
            elif "APl" in y:
                num = y.replace("APl", "")
                str += num + "A;"
            elif "Pl" in y:
                num = y.replace("Pl", "")
                str += num + "P;"
        i += 1
        if i == 10:
            str += "\n"
            i = 0

    f.close()

    return str


def convertdate(data):
    year, month, day = data[2:4], data[4:6], data[6:8]
    newdat = day + "-" + dict[month] + "-" + year
    return newdat


def getinfo(lst):
    issuancedate, cleanbid, cleanask, lastprice = [], [], [], []
    for x in lst:
        line = x.split(';')
        for data in line:
            if "D" in data:
                issuancedate.append(convertdate(data))
            if "B" in data:
                if len(cleanbid) == len(issuancedate):
                    cleanbid[-1] = float(data.replace("B", ""))
                else:
                    cleanbid.append(float(data.replace("B", "")))
            else:
                if len(cleanbid) != len(issuancedate):
                    cleanbid.append(0)

            if "A" in data:
                if len(cleanask) == len(issuancedate):
                    cleanask[-1] = float(data.replace("A", ""))
                else:
                    cleanask.append(float(data.replace("A", "")))
            else:
                if len(cleanask) != len(issuancedate):
                    cleanask.append(0)
            if "P" in data:
                if len(lastprice) == len(issuancedate):
                    lastprice[-1] = float(data.replace("P", ""))
                else:
                    lastprice.append(float(data.replace("P", "")))
            else:
                if len(lastprice) != len(issuancedate):
                    lastprice.append(0)

    return issuancedate, cleanbid, cleanask, lastprice


def convert1(isu, bid):
    new, newbid = [], []
    for i in range(len(isu)):
        if bid[i] != 0:
            new.append(isu[i])
            newbid.append(bid[i])
    return new, newbid


if __name__ == '__main__':
    st = parse()
    lst = st.split("\n")
    issuancedate, cleanbid, cleanask, lastprice = getinfo(lst)[0], getinfo(lst)[1], getinfo(lst)[2], getinfo(lst)[3]
    issuancedate = [pd.to_datetime(d) for d in issuancedate]
    i1, b = convert1(issuancedate, cleanbid)
    i2, a = convert1(issuancedate, cleanask)
    i3, l = convert1(issuancedate, lastprice)
    fig, ax = plt.subplots()

    ax.scatter(i1, b, s=10, c='red', label="CleanBid")
    ax.scatter(i2, a, s=10, c='blue', label="CleanAsk")
    ax.scatter(i3, l, s=10, c='gray', label="LastPrice")
    ax.legend()
    plt.show()
