Elbette, projenizin özelliklerini, sınıflarını ve metodlarını İngilizce olarak ve metodların kısa açıklamaları ile birlikte aşağıda bulabilirsiniz.

---

# Adventure Game

This Java-based text adventure game allows players to choose from different characters, explore various battle locations, and engage in combat with monsters. The game incorporates RPG (Role-Playing Game) elements and is based on strategic thinking and exploration.

## Game Features

- **Multiple Character Options**: Players can choose from various characters, each with distinct abilities and attributes.
- **Battle Locations**: Each location offers unique monsters and rewards.
- **Inventory System**: Players manage the weapons, armors, and rewards they earn.
- **Dynamic Combat Mechanics**: The outcome of each battle depends on the player's decisions and strategy.

## Classes and Methods

### `GameChar`

- Base class for player characters.
- Attributes: `id`, `name`, `damage`, `health`, `money`.
- Methods:
    - `getId`: Returns the character's ID.
    - `getName`: Returns the character's name.
    - `getDamage`: Returns the character's damage.
    - `getHealth`: Returns the character's health.
    - `getMoney`: Returns the character's money.

### `BattleLoc`

- Base class for battle locations.
- Attributes: `monster`, `award`, `maxMonster`.
- Methods:
    - `onLocation`: Triggers when the player enters a location.
    - `combat`: Handles the combat mechanics in the location.
    - `playerStats`: Displays player statistics.
    - `monsterStats`: Displays monster statistics.

### `Armor`

- Represents armors in the game.
- Attributes: `id`, `name`, `block`, `price`.
- Methods:
    - `getId`: Returns the armor's ID.
    - `getName`: Returns the armor's name.
    - `getBlock`: Returns the armor's block value.
    - `getPrice`: Returns the armor's price.

### `Weapon`

- Represents weapons in the game.
- Attributes: `name`, `id`, `damage`, `price`.
- Methods:
    - `getName`: Returns the weapon's name.
    - `getId`: Returns the weapon's ID.
    - `getDamage`: Returns the weapon's damage.
    - `getPrice`: Returns the weapon's price.

### `Player`

- Manages the player character in the game.
- Attributes: `charName`, `damage`, `health`, `money`, `inventory`.
- Methods:
    - `selectChar`: Allows the player to select a character.
    - `initPlayer`: Initializes the player with selected character.
    - `printInfo`: Prints player's current status.
    - `getTotalDamage`: Calculates total damage including weapon damage.

### `Monster`

- Base class for monster characters.
- Attributes: `id`, `name`, `damage`, `health`, `award`.
- Methods:
    - `getName`: Returns the monster's name.
    - `getDamage`: Returns the monster's damage.
    - `getHealth`: Returns the monster's health.
    - `getAward`: Returns the monster's award.

### `Inventory`

- Manages the player's inventory.
- Attributes: `weapon`, `armor`.
- Methods:
    - `getWeapon`: Returns the equipped weapon.
    - `setWeapon`: Sets a weapon to the inventory.
    - `getArmor`: Returns the equipped armor.
    - `setArmor`: Sets an armor to the inventory.

### `Mine (extends BattleLoc)`

- Represents the Mine battle location.
- Attributes and methods from `BattleLoc`, plus:
    - `onLocation`: Activates when the player enters the Mine.
    - `combat`: Handles combat with snakes in the Mine.
    - `playerHitMonster`: Manages the player's attack on the monster.
    - `monsterHitPlayer`: Manages the monster's attack on the player.
    - `giveRandomReward`: Gives random rewards upon defeating monsters.

### `Cave (extends BattleLoc)`
- Represents the Cave battle location.
- Attributes and methods from `BattleLoc`, plus:
    - `onLocation`: Activates when the player enters the Cave.
    - `combat`: Handles combat with zombies in the Cave.
    - `playerHitMonster`: Manages the player's attack on the monster.
    - `monsterHitPlayer`: Manages the monster's attack on the player.
    - `giveRandomReward`: Gives random rewards upon defeating monsters.

### `Forest (extends BattleLoc)`
- Represents the Forest battle location.
- Attributes and methods from `BattleLoc`, plus:
    - `onLocation`: Activates when the player enters the Forest.
    - `combat`: Handles combat with vampires in the Forest.
    - `playerHitMonster`: Manages the player's attack on the monster.
    - `monsterHitPlayer`: Manages the monster's attack on the player.
    - `giveRandomReward`: Gives random rewards upon defeating monsters.

### `ToolStore`
- Represents the Tool Store location.
- Attributes: `weapons`, `armors`.
- Methods:
    - `onLocation`: Activates when the player enters the Tool Store.
    - `printToolStore`: Prints the weapons and armors in the store.
    - `buyWeapon`: Allows the player to buy a weapon.
    - `buyArmor`: Allows the player to buy an armor.

### `Location`
- Base class for locations.
- Attributes: `id`, `name`.
- Methods:
    - `onLocation`: Activates when the player enters a location.
    - `printLocInfo`: Prints the location's information.
    - `printLocs`: Prints the locations in the game.

### `Game`
- Manages the game.
- Attributes: `locations`, `sc`, `player`.
