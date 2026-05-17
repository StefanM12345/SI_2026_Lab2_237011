# SI 2026 Lab 2

Име Презиме: ТВОЕ ИМЕ  
Индекс: 237011

---

## Control Flow Graph - searchBookByTitle

<img width="456" height="842" alt="searchbytittle drawio" src="https://github.com/user-attachments/assets/ab4e94ad-241b-4516-84b2-77a2d2970f58" />


---

## Control Flow Graph - borrowBook

<img width="751" height="1041" alt="borrowbooks drawio" src="https://github.com/user-attachments/assets/d528d153-d960-41f9-bc18-9a3618dbd567" />


---

## Cyclomatic Complexity - searchBookByTitle

Цикломатската комплексност е пресметана според формулата:

M = P + 1

Во функцијата searchBookByTitle има:
- 3 if услови
- 1 for циклус

Затоа:

M = 4 + 1 = 5

Цикломатската комплексност на функцијата е 5.

---

## Cyclomatic Complexity - borrowBook

Цикломатската комплексност е пресметана според формулата:

M = P + 1

Во функцијата borrowBook има:
- 3 if услови
- 1 for циклус

Затоа:

M = 4 + 1 = 5

Цикломатската комплексност на функцијата е 5.
## Every Statement Testing - searchBookByTitle

За исполнување на Every Statement критериумот потребни се минимум 3 тест случаи.

### Test case 1
Input: empty string

Се покриваат следните statements:
- if(title.isEmpty())
- throw new IllegalArgumentException(...)

### Test case 2
Input: existing title ("Clean Code")

Се покриваат:
- for циклусот
- условот:
  if(book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())
- results.add(book)
- return results

### Test case 3
Input: non-existing title ("Unknown")

Се покриваат:
- for циклусот
- if(results.isEmpty())
- return null

Со овие 3 тест случаи се покриваат сите statements во функцијата searchBookByTitle.
