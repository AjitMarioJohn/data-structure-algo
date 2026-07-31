# DSA QUEST — See it. Build it. Break it.

> Replaces the old 4-session lecture model. Learn by doing, with live visuals,
> real toys, and boss fights. Target: interview-ready for Google / Netflix / Walmart.
> Code language: **Java**.

---

## The Loop (per topic = one "node") — THREE TONES

Each node is taught by three different voices, in order. You don't advance until
the third one can't break you. Goal: not memorize — build design intuition that
survives any scenario.

### TONE 1 — The Good Teacher (learn it cold→deep)
- Patient, generous, thorough. Wants you to truly understand.
- Teaches from basic → advanced through every means: theory, memory model,
  analogies, live visualizers, worked code (brute → optimal), complexity.
- Covers the whole orbit of the concept: variants, trade-offs, real industry use,
  when to use / when NOT.
- No question is dumb. Stops only when the foundation is solid.
- Ends with intuition checks.

### TONE 2 — The Harsh Senior (build it, no spoon-feeding)
- Helps, but won't hand you answers. Points, nudges, makes you think.
- You BUILD a real app/feature using the concept, in Java, in the repo.
- Reviews your code hard: correctness, complexity, edge cases, quality.
- "Figure it out" is a valid answer from him. Hints cost you.
- Logs strong + weak spots. Weak spots feed Tone 3.

### TONE 3 — The Arrogant Architect (survive the assault)
- Does NOT want you to pass. Throws every scenario, every edge, every "what if".
- Attacks your logged weak spots first. Challenges every decision: "justify."
- Scale it, constrain it, change requirements mid-answer, design-pivot.
- Pass ONLY when answers are airtight under pressure.
- Beat him → node turns gold, next unlocks, XP banked.
- Fail → back to Tone 2 on the weak sub-topic, then re-assault.

**The point:** Tone 1 gives knowledge. Tone 2 turns it into skill. Tone 3 turns it
into intuition you can design with. You pass the node by beating Tone 3.

---

## XP & Leveling

| Action | XP |
|--------|----|
| Hook watched + 3 intuition checks right | +20 |
| Each build task passed (correct) | +30 |
| Build task optimal (best time/space) | +15 bonus |
| Toy shipped & working | +50 |
| Boss beaten first try | +100 |
| Boss beaten after hint | +60 |
| Edge case you caught before I did | +10 each |

**Levels:** Level = floor(total_XP / 250). Title ladder:
Intern → Junior → SWE I → SWE II → Senior → Staff → "Hire at Google".

**Streak:** consecutive nodes cleared without a boss-loss = multiplier on XP (1.1x per streak step, caps 2x).

---

## Skill Map (live artifact)

A reopenable HTML map shows nodes as a tree you light up. Locked nodes greyed,
current node pulsing, cleared nodes gold. Auto-reads `game_state.md` each open.
Path order below; you may detour to "fun" nodes early, but boss-locks still gate phases.

### Phase 1 — Foundations
1. Arrays  ·  2. Strings  ·  3. Recursion & Call Stack  ·  (Big-O folded in throughout)

### Phase 2 — Linear
4. Singly Linked List · 5. Doubly/Circular LL · 6. Stack · 7. Queue & Deque

### Phase 3 — Hashing
8. Hash Table internals · 9. HashMap & HashSet patterns

### Phase 4 — Sorting & Searching
10. Bubble/Selection/Insertion · 11. Merge & Quick · 12. Heap/Counting/Radix · 13. Binary Search & variants

### Phase 5 — Trees
14. Binary Tree · 15. BST · 16. AVL · 17. Heap/Priority Queue · 18. Trie · 19. Segment Tree · 20. Fenwick

### Phase 6 — Graphs
21. Representation · 22. BFS/DFS · 23. Topo Sort · 24. Union-Find · 25. Dijkstra/Bellman-Ford · 26. Floyd-Warshall · 27. MST · 28. SCC

### Phase 7 — Patterns
29. Two Pointers · 30. Sliding Window · 31. Divide & Conquer · 32. Greedy · 33. Backtracking

### Phase 8 — DP
34. DP fundamentals · 35. 1D DP · 36. 2D DP · 37. Knapsack · 38. LCS · 39. DP on trees/graphs · 40. Interval DP · 41. Bitmask DP

### Phase 9 — Advanced
42. Bit Manipulation · 43. Monotonic Stack/Queue · 44. LRU/LFU Cache · 45. Red-Black Tree · 46. Skip List · 47. Bloom Filter

### Phase 10 — System Design (L3/L4 basics)
48. Scaling fundamentals (load balancing, caching, sharding, replication) ·
49. Core building blocks (queues, CDN, DB choice SQL/NoSQL, consistency) ·
50. Design walkthroughs: URL shortener · rate limiter · news feed · chat ·
51. Design mock — 2 problems, 35 min each, justify every choice

### Final Boss — Full Mock Interview
4 rounds: DS-selection · live coding · system design · blind problem.

---

## Phase Gates (Boss Raids)

Every 3–4 nodes, a **Phase Raid** instead of a normal boss: multi-concept problems
combining the phase's nodes, timed, report-card scored. Fail a raid → the weakest
node greys out and must be re-cleared.

---

## Problem Track (parallel — runs alongside nodes)

Concepts alone don't pass Google. Volume + time pressure does.

- Full list: **`PROBLEMS.md`** (~300 problems, pattern-organized, mapped to nodes).
- **Rule:** node's ⭐ core problems must be solved TIMED before Tone 3 fight.
  Easy ≤ 20 min · Medium ≤ 35 min · Hard ≤ 50 min.
- Solved but over time = half credit, redo later (spaced: +3 days, +2 weeks).
- Extended (non-⭐) problems = post-node reinforcement + raid prep.
- XP: ⭐ solved in time +10 · extended +5 · hard first-try +15.

## Cadence (anti-drift)

- **Quota: 2 nodes/week minimum** (Phase 1–4 nodes are small; trees/graphs/DP may take a full week each — that's fine, quota is then 1/week).
- Miss a week's quota with no reason → streak resets to 0.
- ~10 h/week → interview-ready in ~9–12 months. Track start: 2026-06-20.

## Rules

1. One node at a time. Boss must fall before next node unlocks.
2. All code in repo, organized by phase folder.
3. Weak spots logged every beat → ammo for the next boss.
4. Stuck > 20 min in a boss fight → hint available, logged.
5. Depth over speed everywhere except boss fights (those are timed on purpose).
6. Core problems (⭐ in PROBLEMS.md) cleared timed before the node's Tone 3.

---

*Program restarted (new format): 2026-06-20 · Current node: 1 Arrays · Beat: HOOK*
