import axios from 'axios';


export default class CategoryService {

    

    url = "http://localhost:8080/category/";

    getAll() {
        return axios.get(this.url + "findAllcate");
    }

    save(category) {
        return axios.post(this.url + "addcategory", category)
    }

    delete(categoryId) {
        return axios.get(this.url + "deletecate", categoryId)
    }
}
