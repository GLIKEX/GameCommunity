module.exports = {
    root: true,
    env: {
        node: true,
    },
    extends: ['plugin:vue/essential', 'eslint:recommended', 'plugin:prettier/recommended'],
    parserOptions: {
        // parser: '@babel/eslint-parser',
    },
    rules: {
        // 关闭驼峰命名规则
        'vue/multi-word-component-names': 0
    },
}
