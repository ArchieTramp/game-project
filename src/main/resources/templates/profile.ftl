<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Выбор игрока</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="profile-block">
    <h1 class="profile-title">Добро пожаловать, ${user.lastName} ${user.firstName}!</h1>
    <form class="profile-form">
        <fieldset class="profile-item">
            <label for="players">Доступные игровые персонажи пользователя</label>
        </fieldset>
        <fieldset class="profile-item">
                <#if players??>
                    <#list players as player>
                        <tr><p>
                            <td>${player.nickName}</td>
                            <td><button type="submit" formaction="${'/' + player.id}">Выбрать игрока</button></td>
                            </p>
                        </tr>
                    <#else>
                        <br>Нет доступных игроков
                    </#list>
                </#if>

        </fieldset>
        <fieldset class="profile-item">
            <button type="submit" formmethod="get" formaction="/creatplayer">Создать игрового персонажа</button>
            <button type="submit" formmethod="get" formaction="/users">Для администратора</button>
            <button type="submit" formmethod="get" formaction="/logout">Выход</button>
        </fieldset>
    </form>
</div>

</body>
</html>