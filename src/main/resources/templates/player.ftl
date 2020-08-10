<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Персонаж</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="player-block">
    <h1 class="player-title">Информацию по персонажу ${player.nickName}</h1>
    <form class="player-form">
        <fieldset class="player-item">
            <table class="player-specifications">
                <tr class="player-specifications-item">
                    <td>Уровень</td>
                    <td>Золото</td>
                    <td>HP</td>
                    <td>MP</td>
                    <td>Бандиты</td>
                </tr>
                <tr class="player-specifications-item">
                    <td>${player.level}</td>
                    <td>${player.gold}</td>
                    <td>${player.HP}</td>
                    <td>${player.MP}</td>
                    <td>${player.bandit}</td>
                </tr>
            </table>
        </fieldset>
        <fieldset class="player-item">
            <table class="player-specifications">
                <tr class="player-specifications-item">
                    <td>INT</td>
                    <td>STR</td>
                    <td>CHAR</td>
                    <td>LUCK</td>
                </tr>
                <tr class="player-specifications-item">
                    <td>${player.intelligence}</td>
                    <td>${player.strength}</td>
                    <td>${player.charisma}</td>
                    <td>${player.luck}</td>
                </tr>
            </table>
        </fieldset>
        <fieldset class="registration-item">
            <button type="submit" formmethod="get" formaction="/start">Начать игру</button>
            <button type="submit" formmethod="post" formaction="/creatplayer/delete">Удалить игрока</button>
            <button type="submit" formmethod="get" formaction="/">Вернуться</button>
        </fieldset>
    </form>
</div>

</body>
</html>