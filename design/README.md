# Snake and Ladder - LLD Design Review

## Objective

Implement the classic Snake and Ladder game using Object-Oriented Design principles while keeping the solution extensible, maintainable, and easy to understand.

---

# Requirements Considered

* Support multiple players.
* Support configurable board size.
* Support multiple snakes.
* Support multiple ladders.
* Support turn-by-turn gameplay.
* Support win detection.
* Keep entities loosely coupled.
* Follow OOP and SOLID principles wherever applicable.

---

# Core Entities

## Board

Responsible for:

* Maintaining cells.
* Maintaining snakes.
* Maintaining ladders.
* Moving tokens.
* Applying snake/ladder transitions.
* Detecting winning condition.

---

## Cell

Represents a single position on the board.

Responsibilities:

* Store coordinates.
* Act as a location reference for snakes, ladders, and tokens.

---

## Snake

Represents a downward movement.

Responsibilities:

* Head cell.
* Tail cell.
* Move token from head to tail.

---

## Ladder

Represents an upward movement.

Responsibilities:

* Base cell.
* Top cell.
* Move token from base to top.

---

## User

Represents a player.

Responsibilities:

* Hold token.
* Participate in turns.

---

## Token

Represents player's current position.

Responsibilities:

* Track current cell.

---

## MoveProvider

Abstraction for movement generation.

Current implementation:

* Dice

Future possibilities:

* LoadedDice
* CrookedDice
* RemoteMoveProvider

---

# Good Design Decisions

## 1. Used Interface for Dice

Implemented:

```java
public interface MoveProvider {
    int get();
}
```

Benefit:

* Open for extension.
* Supports different movement generation strategies.
* Follows Open/Closed Principle.

---

## 2. Generic Turn Management

Used:

```java
Deque<User>
```

instead of hardcoded player handling.

Benefit:

* Supports any number of players.
* Cleaner turn rotation.

---

## 3. Board Owns Movement Rules

Movement logic is centralized inside Board.

Benefit:

* Single source of truth.
* Game rules remain consistent.

---

## 4. Recursive Snake/Ladder Handling

Supports scenarios like:

```text
Ladder -> Ladder
Ladder -> Snake
Snake -> Ladder
```

without additional logic.

---

# SOLID Analysis

## Single Responsibility Principle (SRP)

Mostly followed.

Examples:

* Snake handles snake behavior.
* Ladder handles ladder behavior.
* Token handles position.
* Board handles game rules.

---

## Open Closed Principle (OCP)

Partially followed.

MoveProvider abstraction allows extension without modifying existing code.

---

## Liskov Substitution Principle (LSP)

No violations observed.

---

## Interface Segregation Principle (ISP)

Good usage.

MoveProvider exposes only what clients need.

---

## Dependency Inversion Principle (DIP)

Partially violated.

Current implementation:

```java
new Dice()
```

inside User.

User depends on a concrete implementation.

Better:

```java
User(MoveProvider moveProvider)
```

Dependency should be injected.

---

# Design Improvements Identified

## Improvement 1

### Current

User creates Dice.

```java
new Dice()
```

### Better

Inject MoveProvider.

```java
User(MoveProvider moveProvider)
```

Benefit:

* Looser coupling.
* Better testability.
* Better extensibility.

---

## Improvement 2

### Current

User holds Board reference.

```java
User -> Board
```

### Better

Game should coordinate:

```text
Game
 ├── Players
 ├── Board
 └── MoveProvider
```

Benefit:

* Better ownership model.
* Cleaner separation of responsibilities.

---

## Improvement 3

Snake and Ladder can potentially be generalized.

### Current

```text
Snake
Ladder
```

### Alternative

```java
class Jump {
    Cell start;
    Cell end;
}
```

Benefit:

* Less duplicated code.
* Simpler board lookup.

Note:
Current implementation is still perfectly acceptable.

---

## Improvement 4

### Current Complexity

For every move:

```java
for (Snake snake : snakes)
```

```java
for (Ladder ladder : ladders)
```

Complexity:

```text
O(snakes + ladders)
```

### Better

Use:

```java
Map<Cell, Snake>
Map<Cell, Ladder>
```

or

```java
Map<Integer, Jump>
```

Complexity:

```text
O(1)
```

lookup.

---

# Bugs Found During Review

## Bug 1

Board constructor:

```java
this.COLUMN = row;
```

Should be:

```java
this.COLUMN = column;
```

---

## Bug 2

Winning condition.

Current:

```java
cell.getPosX() == ROW
cell.getPosY() == COLUMN
```

Should be:

```java
cell.getPosX() == ROW - 1
cell.getPosY() == COLUMN - 1
```

because indexing starts from 0.

---

## Bug 3

Unsafe returns.

Current:

```java
return snakes.get(0);
```

or

```java
return ladders.get(0);
```

Better:

```java
return null;
```

or throw meaningful exception.

---

## Bug 4

Cell comparison uses:

```java
cell == otherCell
```

Safer approach:

Implement:

```java
equals()
hashCode()
```

inside Cell.

---

# Design Patterns Used

## Strategy Pattern

Although not intentionally added, the following abstraction behaves as Strategy:

```java
MoveProvider
```

Current strategy:

```java
Dice
```

Future strategies:

```java
LoadedDice
RemoteMoveProvider
CrookedDice
```

---

# Lessons Learned

1. Do not force design patterns into a solution.
2. Start with requirements and responsibilities.
3. Patterns should emerge naturally.
4. Dependency Injection improves flexibility.
5. Prefer abstractions over concrete dependencies.
6. Think about ownership of responsibilities.
7. Review time complexity after design is complete.
8. Always validate edge cases.
9. Look for opportunities to reduce coupling.
10. Optimize only after achieving clean design.

---

# What I Would Do In Version 2

* Introduce Game class as orchestrator.
* Inject MoveProvider.
* Use Map-based snake/ladder lookup.
* Implement equals() and hashCode() for Cell.
* Improve win-condition validation.
* Add unit tests.
* Add configurable dice implementation.

---

# Final Takeaway

The solution demonstrates:

* Good OOP understanding.
* Proper entity decomposition.
* Basic SOLID application.
* Extensible architecture.
* Clean and readable code.

The biggest learning from this implementation is that good Low-Level Design is primarily about responsibilities, relationships, and extensibility—not about forcing design patterns into every problem.
