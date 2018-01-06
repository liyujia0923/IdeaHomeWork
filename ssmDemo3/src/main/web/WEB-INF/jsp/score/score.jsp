<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/26
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../comm/easyuiBasic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#scoreDataGrid").datagrid({
                url:'${pageContext.request.contextPath}/score/queryAll',
                method:'GET',
                rownumbers:true,
                striped:true,
                pagination:true,
                checkOnSelect:false,
                toolbar:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function () {
                            alert("添加");
                        }
                    },
                    {
                        text:'删除',
                        iconCls:'icon-remove',
                        handler:function () {
                            var checkScore = $("#scoreDataGrid").datagrid("getChecked");
                            if(checkScore==null || checkScore.length<=0){
                                alert("请选择要删除的成绩");
                                return;
                            }
                            if(confirm("确定要删除吗？")){
                                var idStr = "";
                                $.each(checkScore,function (index, item) {
                                    idStr = idStr + item.id + ",";
                                });
                                $.post("${pageContext.request.contextPath}/score/deleteScoreByList",{"ids":idStr},
                                function (data) {
                                    alert(data.msg);
                                    $("#scoreDataGrid").datagrid('reload');
                                })
                            }

                        }
                    }
                ],
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'grade',title:'班级',formatter:function (value, row, index) {
                        return row.student3.grade3.gradeName;
                    }},
                    {field:'student3',title:'姓名',formatter:function (value,row,index) {
                        return value.studentName;
                    }},
                    {field:'course3',title:'课程',formatter:function (value, row, index) {
                        return value.courseName;
                    }},
                    {field:'score',title:'成绩'},
                    {field:'id',title:'操作列',formatter:function (value,row,index) {
                        var queryScoreById = "<button onclick='queryScoreById("+value+")'>详情</button>";
                        var updateScore = "<button onclick='updateScore("+value+")'>修改</button>";
                        var deleteScore = "<button onclick='deleteScore("+value+")'>删除</button>";
                        return queryScoreById + updateScore + deleteScore;
                    }}
                ]]
            })
            //查询班级
            $.get("${pageContext.request.contextPath}/student/queryGrade",function (grade) {
               var grade1 = $.parseJSON('{"id":-1,"gradeName":"--请选择--"}');
                grade.push(grade1);
                $("#queryGradeCombobox").combobox({
                    valueField:'id',
                    textField:'gradeName',
                    data:grade,
                    onLoadSuccess:function () {
                        $(this).combobox("select", -1);
                    },
                    onSelect:function (grade) {//选中某个班级的时候加载该班级的学生
                        var gradeId = grade.id;
                        $.get("${pageContext.request.contextPath}/student/queryStudentByGradeId",{"gradeId":gradeId},
                            function (student) {
                            var student1 = $.parseJSON('{"id":-1,"studentName":"--请选择--"}');
                            student.push(student1);
                            $("#queryStudentCombobox").combobox({
                                valueField:'id',
                                textField:'studentName',
                                data:student,
                                onLoadSuccess:function () {
                                    $(this).combobox("select", -1);
                                }
                            })
                        })
                        
                    }

                })
            })
            $("#queryScoreButton").click(function () {
                var gradeId = $("#queryGradeCombobox").val();
                var studentId = $("#queryStudentCombobox").val();
                $("#scoreDataGrid").datagrid('load',{
                    "gradeId":gradeId,
                    "studentId":studentId
                })
            })
        })
        function queryScoreById(id) {
          $.get("${pageContext.request.contextPath}/score/queryScoreById",{"id":id},
          function (data) {
              $("#queryGradeName").textbox('setValue', data.student3.grade3.gradeName);
              $("#queryStudentName").textbox('setValue', data.student3.studentName);
              $("#queryCourse").textbox('setValue', data.course3.courseName);
              $("#queryScore").textbox('setValue', data.score);
          })
            $("#queryScoreByIdWindow").window('open');
        }
        function updateScore(id) {
            alert(id);
        }
        function deleteScore(id) {
            $.post("${pageContext.request.contextPath}/score/deleteScoreById",{"id":id},
            function (data) {
                alert(data.msg);
                $("#scoreDataGrid").datagrid('reload');
            })
        }

    </script>
</head>
<body>
    <div>
        <form>
            班级：<input id="queryGradeCombobox" name="gradeId">
            学生：<input id="queryStudentCombobox" name="studentId"/>
            <a id="queryScoreButton" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </form>
    </div>
    <table id="scoreDataGrid"></table>
    <div class="easyui-window" id="queryScoreByIdWindow" style="width: 500px;height: 300px; padding: 60px 120px;"
         title="成绩详情", data-options="{closed:true}">
        <div>
            <form id="queryScoreByIdForm">
                <div>
                    班级：<input class="easyui-textbox" id="queryGradeName">
                </div>
                <div>
                    姓名：<input class="easyui-textbox" id="queryStudentName">
                </div>
                <div>
                    课程：<input class="easyui-textbox" id="queryCourse">
                </div>
                <div>
                    成绩：<input class="easyui-textbox" id="queryScore">
                </div>
            </form>
        </div>
    </div>

</body>
</html>
