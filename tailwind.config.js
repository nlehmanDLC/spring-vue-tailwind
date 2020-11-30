module.exports = {
  purge: {
      content: [
          './src/main/resources/**/*.html',
          './src/main/resources/js/**/*.vue',
        ]
    },
  darkMode: 'class', // or 'media' or 'class'
  theme: {
    extend: {},
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
