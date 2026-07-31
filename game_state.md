# GAME STATE

```
PLAYER:   Ajit
LANGUAGE: Java
LEVEL:    0  (Intern)
TOTAL_XP: 140
STREAK:   0
```

## Current
- Node: **1 — Arrays**
- Tone: **2 — The Harsh Senior**
- Status: build tasks assigned

## Map Progress
| # | Node | Phase | State |
|---|------|-------|-------|
| 1 | Arrays | 1 Foundations | 🔵 current |
| 2 | Strings | 1 Foundations | 🔒 locked |
| 3 | Recursion | 1 Foundations | 🔒 locked |
| 4 | Singly Linked List | 2 Linear | 🔒 locked |
| ... | (full path in QUEST.md) | | 🔒 |

State legend: 🟡 cleared · 🔵 current · 🔒 locked

## XP Log
| Date | Action | XP |
|------|--------|----|
| 2026-06-20 | Program restarted (new format) | 0 |
| 2026-06-22 | Node 1 Arrays — Tone 1 intuition checks (3+/5) | +20 |
| 2026-06-22 | Node 1 Arrays — Tone 2 BUILD correct (12/12, no optimal bonus) | +90 |
| 2026-06-22 | Node 1 Arrays — reverse + moveZeros optimized (O(n), in-place) | +30 |

## Weak Spots (boss ammo)
- **Insert/delete in array middle = O(n) shift.** Confused index *access* (O(1)) with *insertion* (O(n) shift). Re-taught Tone 1. Re-check PASSED (delete example). Minor: shift *direction* fuzzy (deletion shifts left, not "forward").
- Amortized O(1) — knew the mechanism (double + copy) but not the term.
- **Overflow-blind:** originally used sum-trick swap — FIXED (temp swap, understood why).
- **Space vs time trade instinct:** when pushed to optimize rotate, reached for extra array (O(n) space) instead of in-place reverse-thrice. Needs to default to in-place on arrays. rotate rework pending.
- **Negative-index blind:** (i+k)%n breaks on negative k in Java. Watch modulo-of-negatives. → Tone 3 ammo.

## Strong Spots (add)
- reverse: clean two-pointer, O(1) space, overflow-aware.
- moveZeros: correct two-pointer single-pass O(n), in place.

## Strong Spots
- O(1) random access via address formula (Q1 solid).
- Array vs linked-list choice for frequent insert/delete (Q5 solid).

## Toys Shipped
- _(none yet)_
