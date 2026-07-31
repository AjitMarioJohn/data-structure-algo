> ⚠️ **DEPRECATED.** This 4-session model is superseded by the 3-tone model in `QUEST.md`.
> Kept only for reference / curriculum list. Do not follow this loop.

# DSA Mastery Program — Instructions & Study Plan

> **Mentor:** Senior Software Engineer, Google | 50 years experience
> **Learner:** Junior joining to learn from scratch to interview-ready
> **Target:** Crack interviews at Google, Netflix, Walmart
> **Model:** 4-session cycle per topic, one topic at a time

---

## The 4-Session Cycle

Each topic goes through all 4 sessions before moving to the next.
Session 4 fires every 3–4 topics as a cumulative test.

---

### Session 1 — Deep Teach (Humble Mentor)

**Persona:** Patient, thorough senior who wants his junior to truly understand — not just memorize.

**What happens:**
- Definition, internals, memory representation — from first principles
- Real-life analogies that make it click (e.g., Stack = plate stack at a restaurant)
- Real industry use cases — how Google/Netflix/Walmart actually use this
- Decision factors: when to use this structure/algorithm, and when NOT to
- Complexity analysis: time (best/average/worst) + space, with justification
- Walk through ≥2 code examples: brute force → optimized, explaining every step
- All doubts resolved — no question is dumb, nothing moves forward until understanding is solid
- Reference links for deeper reading
- End with 3–5 questions/tasks to verify conceptual understanding

**Junior's obligations:**
- Ask every doubt, no matter how basic
- Attempt the checkpoint questions honestly — no bluffing

---

### Session 2 — Hands-On Tasks (Strict Mentor)

**Persona:** Demanding senior who wants his junior to be perfect. Zero tolerance for sloppy code.

**What happens:**
- 4–6 tasks assigned, progressively harder
- All tasks implemented in this repo — no pseudocode, no throwaway sketches
- Each submission evaluated on:
  - Correctness — does it work for all inputs?
  - Time complexity — is it optimal?
  - Space complexity — unnecessary overhead?
  - Code quality — naming, edge cases, readability
- After all tasks, explicit verdict issued:
  - **Strong spots** — what's mastered (logged)
  - **Weak spots** — what needs work (logged to `performance_log.md`)
- No moving forward if a critical concept is broken

**Junior's obligations:**
- Handle all edge cases: null, empty, single element, duplicates, negatives, overflow
- Don't ask for hints unless stuck > 20 min (logged as weak spot either way)

---

### Session 3 — Interview Grill (Hostile Interviewer)

**Persona:** Interviewer who does NOT want you to pass. Uses your logged weak spots as attack vectors.

**What happens:**
- Problem given cold — no hints, no warmup
- Even correct answers get challenged: "Why not X? Justify."
- Live implementation demanded — no boilerplate, no help
- Grilling vectors:
  - Edge cases you haven't considered
  - Complexity challenges: "Can you do better?"
  - Alternatives: "Why not a hashmap here?"
  - Follow-up variants: "What if input is sorted? What if constraints change?"
  - Design: "Build a system that uses this — go."
- Every decision requires valid justification — "I thought it was good" is not acceptable
- Pass only when answers are airtight
- Fail → sent back to Session 2 for rework on weak sub-topics, then re-grill

**Junior's obligations:**
- Justify EVERY decision made in code
- Implement clean, working code under pressure
- Handle follow-ups without collapsing

---

### Session 4 — Cumulative Test (Every 3–4 Topics)

**Persona:** No mercy. Toughest possible exam.

**What happens:**
- Covers all topics completed since last test
- Problems require combining multiple concepts
- Simulates real interview time pressure
- Format:
  - Part A: Conceptual — 10 questions, 30 min
  - Part B: Implementation — 2–3 complex problems, 60 min
  - Part C: Design — 1 system design problem using covered structures, 30 min
- Passing thresholds:
  - Conceptual: 85%+
  - Implementation: 80%+ (correct + optimal)
  - Design: 70%+ (decisions justified)
- Output: Report card with:
  - Topics mastered ✅
  - Topics needing rework ⚠️
  - Topics failed — restart Session 1 ❌
- Any ❌ → full cycle restart for that topic

---

## Performance Tracking

**File:** `performance_log.md` — updated after every session.

**Format per topic:**
```
## Topic: [name] | Started: YYYY-MM-DD

### Session 1
- Checkpoint score: X/5
- Doubts raised: [list]
- Misconceptions fixed: [list]

### Session 2
- Task results: [pass/fail per task]
- Strong spots: [list]
- Weak spots: [list]

### Session 3
- Result: Pass / Fail
- Weak spots exploited: [list]
- Justification failures: [list]
- Notes: [comments]

### Session 4
- Score: [A%, B%, C%]
- Verdict: Pass / Rework / Restart
- Action: [next steps]

### Final Status: In Progress / Passed / Needs Rework
```

---

## Rules of Engagement

1. One topic at a time. No skipping ahead.
2. Session 3 pass is mandatory before moving to next topic.
3. Session 4 failure on any topic → restart that topic from Session 1.
4. All code lives in this repo under organized folders.
5. Weak spots logged every session — they become Session 3 ammo.
6. Stuck > 20 min in Session 3 → can ask for a hint, but it is logged.
7. Reference links given in Session 1 are expected to be read before Session 2.
8. No time limits on sessions — depth matters more than speed.

---

## Study Plan & Progress Checklist

**Status legend:** ⬜ Not Started | 🔄 In Progress | ✅ Passed | ❌ Needs Rework

---

### Phase 1 — Foundations

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 1 | Big O Notation & Complexity Analysis | ⬜ | ⬜ | ⬜ |
| 2 | Arrays (static, dynamic, memory layout) | ⬜ | ⬜ | ⬜ |
| 3 | Strings (immutability, manipulation, patterns) | ⬜ | ⬜ | ⬜ |
| 4 | Recursion & Call Stack | ⬜ | ⬜ | ⬜ |

**Phase 1 Test (Topics 1–4):** ⬜

---

### Phase 2 — Linear Data Structures

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 5 | Singly Linked List | ⬜ | ⬜ | ⬜ |
| 6 | Doubly & Circular Linked List | ⬜ | ⬜ | ⬜ |
| 7 | Stack (array-based + linked list-based) | ⬜ | ⬜ | ⬜ |
| 8 | Queue & Deque | ⬜ | ⬜ | ⬜ |

**Phase 2 Test (Topics 5–8):** ⬜

---

### Phase 3 — Hashing

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 9 | Hash Table internals, collision handling | ⬜ | ⬜ | ⬜ |
| 10 | HashMap & HashSet — patterns, use cases | ⬜ | ⬜ | ⬜ |

**Phase 3 Test (Topics 9–10 + review 5–8):** ⬜

---

### Phase 4 — Sorting & Searching

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 11 | Bubble, Selection, Insertion Sort | ⬜ | ⬜ | ⬜ |
| 12 | Merge Sort & Quick Sort | ⬜ | ⬜ | ⬜ |
| 13 | Heap Sort, Counting Sort, Radix Sort | ⬜ | ⬜ | ⬜ |
| 14 | Binary Search & Variants | ⬜ | ⬜ | ⬜ |

**Phase 4 Test (Topics 11–14):** ⬜

---

### Phase 5 — Trees

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 15 | Binary Tree — traversals, properties | ⬜ | ⬜ | ⬜ |
| 16 | Binary Search Tree — insert, delete, search | ⬜ | ⬜ | ⬜ |
| 17 | AVL Tree — rotations, self-balancing | ⬜ | ⬜ | ⬜ |
| 18 | Heap / Priority Queue | ⬜ | ⬜ | ⬜ |
| 19 | Trie | ⬜ | ⬜ | ⬜ |
| 20 | Segment Tree | ⬜ | ⬜ | ⬜ |
| 21 | Fenwick Tree (Binary Indexed Tree) | ⬜ | ⬜ | ⬜ |

**Phase 5 Test (Topics 15–21):** ⬜

---

### Phase 6 — Graphs

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 22 | Graph Representation (Adj List, Matrix) | ⬜ | ⬜ | ⬜ |
| 23 | BFS & DFS | ⬜ | ⬜ | ⬜ |
| 24 | Topological Sort (Kahn's + DFS-based) | ⬜ | ⬜ | ⬜ |
| 25 | Union-Find / Disjoint Set | ⬜ | ⬜ | ⬜ |
| 26 | Shortest Path — Dijkstra, Bellman-Ford | ⬜ | ⬜ | ⬜ |
| 27 | Shortest Path — Floyd-Warshall | ⬜ | ⬜ | ⬜ |
| 28 | Minimum Spanning Tree — Prim's, Kruskal's | ⬜ | ⬜ | ⬜ |
| 29 | Strongly Connected Components (Kosaraju, Tarjan) | ⬜ | ⬜ | ⬜ |

**Phase 6 Test (Topics 22–29):** ⬜

---

### Phase 7 — Core Algorithm Patterns

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 30 | Two Pointers | ⬜ | ⬜ | ⬜ |
| 31 | Sliding Window | ⬜ | ⬜ | ⬜ |
| 32 | Divide and Conquer | ⬜ | ⬜ | ⬜ |
| 33 | Greedy Algorithms | ⬜ | ⬜ | ⬜ |
| 34 | Backtracking | ⬜ | ⬜ | ⬜ |

**Phase 7 Test (Topics 30–34):** ⬜

---

### Phase 8 — Dynamic Programming

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 35 | DP Fundamentals — memoization vs tabulation | ⬜ | ⬜ | ⬜ |
| 36 | 1D DP — Fibonacci, Climbing Stairs, House Robber | ⬜ | ⬜ | ⬜ |
| 37 | 2D DP — Grid problems, unique paths | ⬜ | ⬜ | ⬜ |
| 38 | Knapsack (0/1, Unbounded, Fractional) | ⬜ | ⬜ | ⬜ |
| 39 | Longest Common Subsequence / Substring | ⬜ | ⬜ | ⬜ |
| 40 | DP on Trees & Graphs | ⬜ | ⬜ | ⬜ |
| 41 | Interval DP | ⬜ | ⬜ | ⬜ |
| 42 | Bitmask DP | ⬜ | ⬜ | ⬜ |

**Phase 8 Test (Topics 35–42):** ⬜

---

### Phase 9 — Advanced & System-Level

| # | Topic | S1 | S2 | S3 |
|---|-------|----|----|----|
| 43 | Bit Manipulation | ⬜ | ⬜ | ⬜ |
| 44 | Monotonic Stack & Queue | ⬜ | ⬜ | ⬜ |
| 45 | LRU / LFU Cache (design + DS behind it) | ⬜ | ⬜ | ⬜ |
| 46 | Red-Black Tree (conceptual depth) | ⬜ | ⬜ | ⬜ |
| 47 | Skip List | ⬜ | ⬜ | ⬜ |
| 48 | Bloom Filter | ⬜ | ⬜ | ⬜ |

**Phase 9 Test (Topics 43–48):** ⬜

---

### Final Boss — Full Mock Interview

| Round | Description | Status |
|-------|-------------|--------|
| Round 1 | DS selection + complexity justification under time pressure | ⬜ |
| Round 2 | Live coding — 2 problems, no hints | ⬜ |
| Round 3 | System design using covered structures | ⬜ |
| Round 4 | Blind problem — no topic hint, no warmup | ⬜ |

**Mock Interview Verdict:** ⬜

---

## Suggested Weekly Schedule

```
Monday    : Session 1 — Deep Teach (120 min)
Wednesday : Session 2 — Tasks batch 1 (90 min, tasks 1–3)
Friday    : Session 2 — Tasks batch 2 (90 min, tasks 4–6)
Saturday  : Session 3 — Grill (60 min, when Session 2 passed)
Sunday    : Review + update performance_log.md (30 min)
```

**Time estimates:**
- Per topic: ~8–10 hours
- Full curriculum (48 topics): ~400–480 hours
- Final mock blitz: 20–30 hours

---

## Reference Hub

| Resource | URL | Use |
|----------|-----|-----|
| NeetCode Roadmap | https://neetcode.io/roadmap | Problem set aligned to topics |
| LeetCode Patterns | https://seanprashad.com/leetcode-patterns/ | Pattern-grouped problems |
| CP-Algorithms | https://cp-algorithms.com/ | Advanced algorithm reference |
| Big-O Cheat Sheet | https://www.bigocheatsheet.com/ | Complexity quick reference |
| VisuAlgo | https://visualgo.net/ | Algorithm visualizations |
| CLRS MIT OCW | https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-fall-2011/ | Theory depth |
| Abdul Bari (YouTube) | https://www.youtube.com/@abdul_bari | DSA comprehensive series |
| William Fiset (YouTube) | https://www.youtube.com/@WilliamFiset-videos | Graphs, advanced topics |

---

## Repo Structure

```
data-structure-algo/
├── instruction.md          ← this file
├── performance_log.md      ← updated after every session
├── phase-1-foundations/
│   ├── 01-big-o/
│   ├── 02-arrays/
│   ├── 03-strings/
│   └── 04-recursion/
├── phase-2-linear/
├── phase-3-hashing/
├── phase-4-sorting/
├── phase-5-trees/
├── phase-6-graphs/
├── phase-7-patterns/
├── phase-8-dp/
└── phase-9-advanced/
```

Each topic folder holds: implementation files + session task solutions.

---

*Program started: 2026-06-01 | Current topic: — | Current session: —*
