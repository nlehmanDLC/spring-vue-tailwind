module.exports = {
  purge: {
      content: [
          './src/main/resources/**/*.html',
          './frontend/**/*.vue',
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
