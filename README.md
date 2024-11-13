# LeetCode Master

Let's goooooo!

## LeetCode Master Plugin Setup
### URL
```
leetcode.cn
```

### TempFilePath
```
{path_to_project_base_dir}\leetcode-master
```

### CheckBoxes
- [x] Custom Template
- [x] Show Tool Icon
- [x] Plugin Update
- [ ] Cookie
- [x] Show Editor Sign
- [x] Converge Editor
- [x] Show Topics
- [x] English Content
- [x] Multiline
- [ ] Html Content

### Code FileName
```
Q$!{question.frontendQuestionId}_$velocityTool.camelCaseName(${question.titleSlug})
```

### Code Template
```
package leetcode.editor.cn;
${question.content}

public class Q$!{question.frontendQuestionId}_$velocityTool.camelCaseName(${question.titleSlug}) {
    public static void main(String[] args) {
        Solution solution = new Q$!{question.frontendQuestionId}_$velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
    ${question.code}
}
```