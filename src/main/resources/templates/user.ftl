<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Информация о пользователе</title>
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>
<div class="player-block">
    <h1 class="player-title">Информация о пользователе</h1>
    <form class="player-form">
        <fieldset class="player-item">
            <fieldset class="player-item">
                <table class="player-specifications">
                    <tr class="player-specifications-item">
                        <td>ID</td>
                        <td>Last Name</td>
                        <td>First Name</td>
                        <td>State</td>
                    </tr>
                    <tr class="player-specifications-item">
                        <td>${user.id}</td>
                        <td>${user.lastName}</td>
                        <td>${user.firstName}</td>
                        <td>${user.state}</td>
                    </tr>
                </table>
            </fieldset>
        </fieldset>
        <fieldset class="registration-item">
            <button type="submit" formmethod="post" formaction="${'/users/' + user.id}">Забанить</button>
            <#if message??>
                <div class="alert alert-danger" role="alert">${message}</div>
            </#if>
            <button type="submit" formmethod="post" formaction="${'/users/restore/' + user.id}">Восстановить</button>
            <#if message1??>
                <div class="alert alert-danger" role="alert">${message1}</div>
            </#if>
            <button type="submit" formmethod="get" formaction="/users">Вернуться</button>
        </fieldset>
    </form>
</div>

</body>
</html>


<#--<html>-->
<#--<head>-->
<#--    <title>Title</title>-->
<#--    <link href="/css/styles.css" rel="stylesheet" type="text/css">-->
<#--    <link href="/css/bootstrap.min.css" rel="stylesheet"/>-->
<#--</head>-->

<#--<body>-->

<#--<div class="form-style-2">-->
<#--    <div class="form-style-2-heading">-->
<#--        Пользователь-->
<#--    </div>-->
<#--        <table border="0">-->
<#--            <tr>-->
<#--                <td>Id</td>-->
<#--                <td>:</td>-->
<#--                <td>${user.id}</td>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <td>LastName</td>-->
<#--                <td>:</td>-->
<#--                <td>${user.lastName}</td>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <td>FirstName</td>-->
<#--                <td>:</td>-->
<#--                <td>${user.firstName}</td>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <td>State</td>-->
<#--                <td>:</td>-->
<#--                <td>${user.state}</td>-->
<#--            </tr>-->
<#--        </table>-->

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
<#--</div>-->

<#--<a href="/users">Вернуться к списку пользователей</a>-->

<#--</body>-->
<#--</html>-->