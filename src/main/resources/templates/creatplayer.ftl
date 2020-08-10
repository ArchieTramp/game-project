<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание персонажа</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="autorization-block">
    <h1 class="autorization-title">Создание игрока</h1>
    <form class="autorization-form">
        <fieldset class="autorization-item">
            <label for="login">Никнейм персонажа
                <input type="text" id="nick-name" name="nickName">
                <#if message??>
                    <div class="alert alert-danger" role="alert">${message}</div>
                </#if>
                <#if messageNickName??>
                    <div class="alert alert-danger" role="alert">${messageNickName}</div>
                </#if>
            </label>
        </fieldset>
        <fieldset class="registration-item">
            <button type="submit" formmethod="post" formaction="/creatplayer">Создать</button>
            <button type="submit" formmethod="get" formaction="/">Вернуться</button>
        </fieldset>
    </form>
</div>

</body>
</html>