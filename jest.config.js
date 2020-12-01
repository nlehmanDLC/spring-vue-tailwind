module.exports = {
    verbose: true,
    roots: ["<rootDir>/src/main/resources/js"],
    moduleFileExtensions: ['js', 'vue'],
    testPathIgnorePatterns: ["bin"],
    moduleNameMapper: {
        '^@/(.*)$': '<rootDir>/src/main/resources/js/$1'
    },
    transform: {
        "^.+\\.js$": "<rootDir>/node_modules/babel-jest",
        "^.+\\.vue$": "<rootDir>/node_modules/vue-jest",
    },
    snapshotSerializers: [
        "<rootDir>/node_modules/jest-serializer-vue"
    ]
}
