<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Жертва
    </div>
    <table>
        <tr>
            <th>NickName</th>
            <th>Level</th>
            <th>Action</th>
        </tr>
        <#list players as player2>
            <#if player2.id != player.id>
            <tr>
                    <br>
                    <td>${player2.nickName}</td>
                    <td>${player2.level}</td>
                <td><form action="${'/lootplayer/' + player2.id}" method="post">
                    <input class="action-item" type="submit" value="Ограбить">
                </form></td>
                    <br>
<#--                </form>-->
            </tr>
            </#if>
        </#list>
    </table>

    <#--        <br/><br/>-->

    <#--        <form action="${'/users/' + user.id}" method="post">-->
    <#--            Забанить этого пользователя? <input type="submit" value="Yes"/>-->
    <#--            <#if message??>-->
    <#--                <div class="alert alert-danger" role="alert">${message}</div>-->
    <#--            </#if>-->
    <#--        </form>-->

    <#--        <form action="${'/users/restore/' + user.id}" method="post">-->
    <#--        Восстановить этого пользователя? <input type="submit" value="Yes"/>-->
    <#--            <#if message1??>-->
    <#--                <div class="alert alert-danger" role="alert">${message1}</div>-->
    <#--            </#if>-->
    <#--        </form>-->
</div>

<a href="/start">Передумать</a>

</body>
</html>