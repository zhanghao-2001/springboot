function changeAdminFlag(Content) {
    var row = parent.parent.headFrame.document.all.Trans.rows[0];
    row.cells[3].innerHTML = Content;
    return true;
}

function ConfirmDelSort(Result, ID) {
    if (confirm("是否确定删除本类、子类及下属所有信息？")) {
        window.location.href = Result + ".asp?Action=Del&ID=" + ID
    }
}

function AddToSort(imagePath) {
    window.opener.LPform.LPattern.focus();
    window.opener.document.LPform.LPattern.value = imagePath;
    window.opener = null;
    window.close();
}

function OpenScript(url, width, height) {
    var win = window.open(url, "SelectToSort", 'width=' + width + ',height=' + height + ',resizable=no,scrollbars=yes,menubar=no,status=no,location=no');
}

function EndSortChange(a, b) {
    if (eval(a).style.display == '') {
        eval(a).style.display = 'none';
        eval(b).className = 'SortEndFolderOpen';
    } else {
        eval(a).style.display = '';
        eval(b).className = 'SortEndFolderClose';
    }
}

function SortChange(a, b) {
    if (eval(a).style.display == '') {
        eval(a).style.display = 'none';
        eval(b).className = 'SortFolderOpen';
    } else {
        eval(a).style.display = '';
        eval(b).className = 'SortFolderClose';
    }
}

function CheckOthers(form) {
    for (var i = 0; i < form.elements.length; i++) {
        var e = form.elements[i];
        if (e.checked == false) {
            e.checked = true;
        } else {
            e.checked = false;
        }
    }
}

function CheckAll(form) {
    for (var i = 0; i < form.elements.length; i++) {
        var e = form.elements[i];
        e.checked = true;
    }
}

function ConfirmDel(message) {
    if (confirm(message)) {
        document.formDel.submit()
    }
}

function OpenDialog(sURL, iWidth, iHeight) {
    var oDialog = window.open(sURL, "_EditorDialog", "width=" + iWidth.toString() + ",height=" + iHeight.toString() + ",resizable=no,left=0,top=0,scrollbars=no,status=no,titlebar=no,toolbar=no,menubar=no,location=no");
    oDialog.focus();
}

//���������ַ�����Ч�ԣ�0-9��a-z,-,_��-------------------------------------------
function voidNum(argValue) {
    var flag1 = false;
    var compStr = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-";
    var length2 = argValue.length;
    for (var iIndex = 0; iIndex < length2; iIndex++) {
        var temp1 = compStr.indexOf(argValue.charAt(iIndex));
        if (temp1 == -1) {
            flag1 = false;
            break;
        } else {
            flag1 = true;
        }
    }
    return flag1;
}

function CheckAdminLogin() {
    var check;
    if (!voidNum(document.AdminLogin.LoginName.value)) {
        alert("请正确输入管理员名称(必须为0-9,a-z,-_组合)！");
        document.AdminLogin.LoginName.focus();
        return false;
        exit;
    }
    if (!voidNum(document.AdminLogin.LoginPassword.value)) {
        alert("请输入管理员密码！");
        document.AdminLogin.LoginPassword.focus();
        return false;
        exit;
    }
    if (!voidNum(document.AdminLogin.CheckCode.value)) {
        alert("请正确输入验证码！");
        document.AdminLogin.CheckCode.focus();
        return false;
        exit;
    }
    return true;
}

function CheckAdminEdit() {
    if (document.editForm.AdminName.value.length < 3 || document.editForm.AdminName.value.length > 10) {
        alert("请正确输入登录名称(必须为0-9,a-z,-_组合)！");
        document.editForm.AdminName.focus();
        return false;
        exit;
    }
    var check;
    if (!voidNum(document.editForm.AdminName.value)) {
        alert("请正确输入登录名称(必须为0-9,a-z,-_组合)！");
        document.editForm.AdminName.focus();
        return false;
        exit;
    }
}

function CheckMemEdit() {
    if (document.editMemForm.MemName.value.length < 3 || document.editMemForm.MemName.value.length > 16) {
        alert("请正确输入登录名称(必须为0-9,a-z,-_组合)！");
        document.editMemForm.MemName.focus();
        return false;
        exit;
    }
    var check;
    if (!voidNum(document.editMemForm.MemName.value)) {
        alert("请正确输入登录名称(必须为0-9,a-z,-_组合)！");
        document.editMemForm.MemName.focus();
        return false;
        exit;
    }
}

function AdminOut() {
    if (confirm("您真的要退出管理操作吗？"))
        location.replace("CheckAdmin.asp?AdminAction=Out")
}

function GoPage(Myself) {
    window.location.href = Myself + "Page=" + document.formDel.SkipPage.value;
}

function AddSort(SortNameCH, ID, Path) {
    window.opener.editForm.SortNameCH.focus();
    window.opener.document.editForm.SortNameCH.value = SortNameCH;
    window.opener.document.editForm.SortID.value = ID;
    window.opener.document.editForm.SortPath.value = Path;
    window.opener = null;
    window.close();
}

function getValue(obj, inputObj) {
    var myObj = inputObj.nextSibling.nextSibling.childNodes[0].childNodes[0].cells[2].childNodes;
    if (obj.innerHTML)
        inputObj.value = myObj[0].innerHTML + "-" + myObj[2].innerHTML + "-" + obj.innerHTML;
    inputObj.nextSibling.nextSibling.style.display = 'none';
    for (i = 0; i < obj.parentNode.parentNode.parentNode.cells.length; i++)
        obj.parentNode.parentNode.parentNode.cells[i].className = '';
    obj.className = 'ds_border2'
}

var DS_x, DS_y;

function dateSelector() {
    var myDate = new Date();
    this.year = myDate.getFullYear();
    this.month = myDate.getMonth() + 1;
    this.date = myDate.getDate();
    this.inputName = '';
    this.display = display;
}

function display() {
    var week = new Array('��', 'һ', '��', '��', '��', '��', '��');

    document.write("<style type=text/css>");
    document.write("  .ds_font td,span  { font: normal 12px ����; color: #000000; }");
    document.write("  .ds_border  { border: 1px solid #000000; cursor: hand; background-color: #DDDDDD }");
    document.write("  .ds_border2  { border: 1px solid #000000; cursor: hand; background-color: #DDDDDD }");
    document.write("</style>");

    document.write("<input style='width:72px;text-align:left;' class='textfield' id='DS_" + this.inputName + "' name='" + this.inputName + "' value='" + this.year + "-" + this.month + "-" + this.date + "' title=˫���ɽ��б༩ ondblclick='this.readOnly=false;this.focus()' onblur='this.readOnly=true' readonly>");
    document.write("<button style='width:60px;height:18px;font-size:12px;margin:1px;border:1px solid #A4B3C8;background-color:#DFE7EF;' type=button onclick=this.nextSibling.style.display='block' onfocus=this.blur()>ѡ������</button>");

    document.write("<div style='position:absolute;display:none;text-align:center;width:0px;height:0px;overflow:visible' onselectstart='return false;'>");
    document.write("  <div style='position:absolute;left:-60px;top:20px;width:142px;height:165px;background-color:#F6F6F6;border:1px solid #245B7D;' class=ds_font>");
    document.write("    <table cellpadding=0 cellspacing=1 width=140 height=20 bgcolor=#CEDAE7 onmousedown='DS_x=event.x-parentNode.style.pixelLeft;DS_y=event.y-parentNode.style.pixelTop;setCapture();' onmouseup='releaseCapture();' onmousemove='dsMove(this.parentNode)' style='cursor:move;'>");
    document.write("      <tr align=center>");
    document.write("        <td width=12% onmouseover=this.className='ds_border' onmouseout=this.className='' onclick=subYear(this) title='��С���'>&lt;&lt;</td>");
    document.write("        <td width=12% onmouseover=this.className='ds_border' onmouseout=this.className='' onclick=subMonth(this) title='��С�·�'>&lt;</td>");
    document.write("        <td width=52%><b>" + this.year + "</b><b>��</b><b>" + this.month + "</b><b>��</b></td>");
    document.write("        <td width=12% onmouseover=this.className='ds_border' onmouseout=this.className='' onclick=addMonth(this) title='�����·�'>&gt;</td>");
    document.write("        <td width=12% onmouseover=this.className='ds_border' onmouseout=this.className='' onclick=addYear(this) title='�������'>&gt;&gt;</td>");
    document.write("      </tr>");
    document.write("    </table>");

    document.write("    <table cellpadding=0 cellspacing=0 width=140 height=20 onmousedown='DS_x=event.x-parentNode.style.pixelLeft;DS_y=event.y-parentNode.style.pixelTop;setCapture();' onmouseup='releaseCapture();' onmousemove='dsMove(this.parentNode)' style='cursor:move;'>");
    document.write("      <tr align=center>");
    for (i = 0; i < 7; i++)
        document.write("      <td>" + week[i] + "</td>");
    document.write("      </tr>");
    document.write("    </table>");

    document.write("    <table cellpadding=0 cellspacing=2 width=140 bgcolor=#EEEEEE>");
    for (i = 0; i < 6; i++) {
        document.write("    <tr align=center>");
        for (j = 0; j < 7; j++)
            document.write("    <td width=10% height=16 onmouseover=if(this.innerText!=''&&this.className!='ds_border2')this.className='ds_border' onmouseout=if(this.className!='ds_border2')this.className='' onclick=getValue(this,document.all('DS_" + this.inputName + "'))></td>");
        document.write("    </tr>");
    }
    document.write("    </table>");

    document.write("    <span style=cursor:hand onclick=this.parentNode.parentNode.style.display='none'>���رա�</span>");
    document.write("  </div>");
    document.write("</div>");

    dateShow(document.all("DS_" + this.inputName).nextSibling.nextSibling.childNodes[0].childNodes[2], this.year, this.month)
}

function subYear(obj) {
    var myObj = obj.parentNode.parentNode.parentNode.cells[2].childNodes;
    myObj[0].innerHTML = eval(myObj[0].innerHTML) - 1;
    dateShow(obj.parentNode.parentNode.parentNode.nextSibling.nextSibling, eval(myObj[0].innerHTML), eval(myObj[2].innerHTML))
}

function addYear(obj) {
    var myObj = obj.parentNode.parentNode.parentNode.cells[2].childNodes;
    myObj[0].innerHTML = eval(myObj[0].innerHTML) + 1;
    dateShow(obj.parentNode.parentNode.parentNode.nextSibling.nextSibling, eval(myObj[0].innerHTML), eval(myObj[2].innerHTML))
}

function subMonth(obj) {
    var myObj = obj.parentNode.parentNode.parentNode.cells[2].childNodes;
    var month = eval(myObj[2].innerHTML) - 1;
    if (month == 0) {
        month = 12;
        subYear(obj);
    }
    myObj[2].innerHTML = month;
    dateShow(obj.parentNode.parentNode.parentNode.nextSibling.nextSibling, eval(myObj[0].innerHTML), eval(myObj[2].innerHTML))
}

function addMonth(obj) {
    var myObj = obj.parentNode.parentNode.parentNode.cells[2].childNodes;
    var month = eval(myObj[2].innerHTML) + 1;
    if (month == 13) {
        month = 1;
        addYear(obj);
    }
    myObj[2].innerHTML = month;
    dateShow(obj.parentNode.parentNode.parentNode.nextSibling.nextSibling, eval(myObj[0].innerHTML), eval(myObj[2].innerHTML))
}

function dateShow(obj, year, month) {
    var myDate = new Date(year, month - 1, 1);
    var today = new Date();
    var day = myDate.getDay();
    var selectDate = obj.parentNode.parentNode.previousSibling.previousSibling.value.split('-');
    var length;
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            length = 31;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            length = 30;
            break;
        case 2:
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
                length = 29;
            else
                length = 28;
    }
    for (i = 0; i < obj.cells.length; i++) {
        obj.cells[i].innerHTML = '';
        obj.cells[i].style.color = '';
        obj.cells[i].className = '';
    }
    for (i = 0; i < length; i++) {
        obj.cells[i + day].innerHTML = (i + 1);
        if (year == today.getFullYear() && (month - 1) == today.getMonth() && (i + 1) == today.getDate())
            obj.cells[i + day].style.color = 'red';
        if (year == eval(selectDate[0]) && month == eval(selectDate[1]) && (i + 1) == eval(selectDate[2]))
            obj.cells[i + day].className = 'ds_border2';
    }
}

function getValue(obj, inputObj) {
    var myObj = inputObj.nextSibling.nextSibling.childNodes[0].childNodes[0].cells[2].childNodes;
    if (obj.innerHTML)
        inputObj.value = myObj[0].innerHTML + "-" + myObj[2].innerHTML + "-" + obj.innerHTML;
    inputObj.nextSibling.nextSibling.style.display = 'none';
    for (i = 0; i < obj.parentNode.parentNode.parentNode.cells.length; i++)
        obj.parentNode.parentNode.parentNode.cells[i].className = '';
    obj.className = 'ds_border2'
}

//ʵ�ֲ������
function dsMove(obj) {
    if (event.button == 1) {
        var X = obj.clientLeft;
        var Y = obj.clientTop;
        obj.style.pixelLeft = X + (event.x - DS_x);
        obj.style.pixelTop = Y + (event.y - DS_y);
    }
}

function test() {
    if (!confirm('是否确定进行批量操作？操作后不能恢复！')) return false;
}

function num_1() {
    var num_1 = document.getElementById("Num_1").value;
    var num_1_str = document.getElementById("num_1_str");
    var str;
    str = "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
    for (var i = 0; i < num_1; i++) {
        str = str + "<tr><td height='28'>";
        str = str + "属性名称：<input name='attributeCh" + (parseInt(i) + 1) + "' type='text' id='attributeCh" + (parseInt(i) + 1) + "' size='18' /> ����ֵ��<input name='attributeCh" + (parseInt(i) + 1) + "_value' type='text' id='attributeCh" + (parseInt(i) + 1) + "_value' size='50' /></td>";
        str = str + "</tr>";
    }
    str = str + "</table>";
    num_1_str.innerHTML = str;
}

function num_1_1() {
    var num_1 = document.getElementById("Num_1").value;
    var num_1_str = document.getElementById("num_1_str");
    var str;
    str = "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
    str = str + "<tr><td height='28'>";
    str = str + "�������ƣ�<input name='attributeCh" + (parseInt(num_1) + 1) + "' type='text' id='attributeCh" + (parseInt(num_1) + 1) + "' size='18' /> ����ֵ��<input name='attributeCh" + (parseInt(num_1) + 1) + "_value' type='text' id='attributeCh" + (parseInt(num_1) + 1) + "_value' size='50' /></td>";
    str = str + "</tr>";
    str = str + "</table>";
    num_1_str.innerHTML = num_1_str.innerHTML + str;
    document.getElementById("Num_1").value = (parseInt(num_1) + 1);
}

function num_2() {
    var num_2 = document.getElementById("num_2").value;
    var num_2_str = document.getElementById("num_2_str");
    var str;
    str = "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
    for (var i = 0; i < num_2; i++) {
        str = str + "<tr><td height='28'>";
        str = str + "属性名称：<input name='attributeEn" + (parseInt(i) + 1) + "' type='text' id='attributeEn" + (parseInt(i) + 1) + "' size='18' /> ����ֵ��<input name='attributeEn" + (parseInt(i) + 1) + "_value' type='text' id='attributeEn" + (parseInt(i) + 1) + "_value' size='50' /></td>";
        str = str + "</tr>";
    }
    str = str + "</table>";
    num_2_str.innerHTML = str;
}

function num_2_1() {
    var num_2 = document.getElementById("num_2").value;
    var num_2_str = document.getElementById("num_2_str");
    var str;
    str = "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
    str = str + "<tr><td height='28'>";
    str = str + "属性名称：<input name='attributeEn" + (parseInt(num_2) + 1) + "' type='text' id='attributeEn" + (parseInt(num_2) + 1) + "' size='18' /> ����ֵ��<input name='attributeEn" + (parseInt(num_2) + 1) + "_value' type='text' id='attributeEn" + (parseInt(num_2) + 1) + "_value' size='50' /></td>";
    str = str + "</tr>";
    str = str + "</table>";
    num_2_str.innerHTML = num_2_str.innerHTML + str;
    document.getElementById("num_2").value = (parseInt(num_2) + 1);
}

function CopyWebTitleCH(v) {
    document.editForm.SeoKeywordsCH.value = v;
    document.editForm.SeoDescriptionCH.value = v;
}

function CopyWebTitleEN(v) {
    document.editForm.SeoKeywordsEN.value = v;
    document.editForm.SeoDescriptionEN.value = v;
}