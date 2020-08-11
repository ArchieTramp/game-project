<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вызов игрока</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="profile-block">
    <h1 class="profile-title">Выбирай жертву, ковбой!</h1>
    <form class="profile-form">
        <fieldset class="profile-item">
            <label for="players">Доступные противники</label>
        </fieldset>
        <fieldset class="profile-item">
            <#list players as player2>
                <#if player2.id != player.id>
                    <tr><p>
                        <td>${player2.nickName}</td>
                        <td>LVL: ${player2.level}</td>
                        <td>STR: ${player2.strength}</td>
                        <td>LUCK: ${player2.luck}</td>
                        <td><button type="submit" formaction="${'/start/players/' + player2.id}">Выбрать</button></td>
                        </p>
                    </tr>
                </#if>
            <#else>
                <br>Нет доступных игроков
            </#list>

        </fieldset>
        <fieldset class="profile-item">
            <button type="submit" formmethod="get" formaction="/start">Струсить</button>
        </fieldset>
    </form>
</div>

</body>
</html>