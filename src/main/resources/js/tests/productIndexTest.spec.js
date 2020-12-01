import axios from 'axios'
import { mount } from '@vue/test-utils'
import ProductIndex from '@/components/ProductIndex'

jest.mock('axios')
window.axios = axios

it('fetches data', done => {
    axios.get.mockResolvedValue({data: ['blah']})
    const wrapper = mount(ProductIndex, {
        stubs: ['router-link', 'router-view']
    })
    wrapper.vm.$nextTick(() => {
        expect(wrapper.vm.products).toStrictEqual(['blah'])
        done()
    })
})

describe('filters', () => {
    let wrapper
    beforeEach(() => {
        const getProductsSpy = jest.spyOn(ProductIndex.methods, 'getProducts')
            .mockImplementation(() => {});
        wrapper = mount(ProductIndex, {
            data() {
                return {
                    categories: ["foo", "bar"],
                    products: [
                        {
                            name: 'apple',
                            category: 'foo'
                        },
                        {
                            name: 'banana',
                            category: 'bar'
                        }
                    ],
                    selectedCategories: [],
                    showFilters: false,
                }
            },
            stubs: ['router-link', 'router-view']
        })
    })
    it('hides filter by default', () => {
        expect(wrapper.vm.showFilters).toBe(false)
    })
    it('clicking filter button shows filters', () => {
        let filterToggle = wrapper.find('#filterToggle')
        filterToggle.trigger('click')
        expect(wrapper.vm.showFilters).toBe(true)
        expect(wrapper.findAll('li.category').length).toBe(2)
    })
    it('clicking on a category toggles it in the selected categories', () => {
        let fooCategoryButton = wrapper.find("li.category")
        fooCategoryButton.trigger("click")
        expect(wrapper.vm.selectedCategories).toEqual(expect.arrayContaining(["foo"]))
        fooCategoryButton.trigger("click")
        expect(wrapper.vm.selectedCategories).toEqual(expect.not.arrayContaining(["foo"]))
    })
    it('shows all products if no categories have been selected', () => {
        expect(wrapper.vm.filteredProducts.length).toBe(2)
    })
    it('filters the product if a category is selected', () => {
        let fooCategoryButton = wrapper.find("li.category")
        fooCategoryButton.trigger("click")
        expect(wrapper.vm.filteredProducts.length).toBe(1)
    })
})
