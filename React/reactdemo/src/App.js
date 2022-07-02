import CategoryList from "./CategoryList";
import Navi from "./Navi";
import ProductList from "./ProductList";
import { Container, Row, Col } from "reactstrap";
import { Component } from "react";
import alertify from "alertifyjs";
import { Routes, Route, Router } from "react-router-dom";
import NotFound from "./NotFound";
import CartList from "./CartList";
import FormDemo1 from "./FormDemo1";
import FormDemo2 from "./FormDemo2";

export default class App extends Component {
  categoryInfo = { title: "Categories" };
  productInfo = { title: "Products" };
  state = {
    currentCategory: "",
    selectedProduct: null,
    products: [],
    categories: [],
    cart: [],
  };

  componentDidMount() {
    this.getProducts();
  }

  getCategories = () => {
    fetch("http://localhost:3000/categories")
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          categories: data,
        });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  changeCategory = (category) => {
    this.setState({ currentCategory: category.categoryName });
    this.getProducts(category.id);
  };

  removeFromCart = (product) => {
    let newCart = this.state.cart.filter(
      (item) => item.product.id !== product.id
    );
    this.setState({ cart: newCart });
    alertify.danger(product.productName + " removed from cart");
  };

  addToCart = (product) => {
    let newCart = this.state.cart;
    var addedItem = newCart.find((c) => c.product.id === product.id);
    if (addedItem) {
      addedItem.quantity++;
    } else {
      newCart.push({ product: product, quantity: 1 });
    }
    this.setState({ cart: newCart });

    alertify.notify(`${product.productName} added to cart`, "success", 5);
  };

  getProducts = (categoryId) => {
    let url = "http://localhost:3000/products";
    if (categoryId) {
      url += "?categoryId=" + categoryId;
    }

    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          products: data,
        });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  render() {
    return (
      <div>
        <Container>
          <Navi removeFromCart={this.removeFromCart} cart={this.state.cart} />

          <Row>
            <Col xs="3">
              <CategoryList
                currentCategory={this.state.currentCategory}
                changeCategory={this.changeCategory}
                info={this.categoryInfo}
                categories={this.state.categories}
              ></CategoryList>
            </Col>
            <Col xs="9">
              <Routes>
                <Route
                  exact
                  path="/"
                  element={
                    <ProductList
                      addToCart={this.addToCart}
                      currentCategory={this.state.currentCategory}
                      products={this.state.products}
                      info={this.productInfo}
                    />
                  }
                />

                <Route
                  exact
                  path="/cart"
                  element={
                    <CartList
                      removeFromCart={this.removeFromCart}
                      cart={this.state.cart}
                    />
                  }
                />
                <Route path="/form1" element={<FormDemo1/>}/>
                <Route path="/form2" element={<FormDemo2/>}/>

                <Route element={<NotFound />} />
              </Routes>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
