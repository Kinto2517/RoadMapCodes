import React, { Component } from "react";
import { Link } from "react-router-dom";
import {
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  Badge,
  NavItem,
  NavLink,
} from "reactstrap";
export default class CartSummary extends Component {
  renderSummary() {
    return (
      <UncontrolledDropdown inNavbar nav>
        <DropdownToggle caret nav>
          Your Cart <Badge color="secondary">{this.props.cart.length}</Badge>
        </DropdownToggle>
        <DropdownMenu right>
          {this.props.cart.map((product) => (
            <DropdownItem key={product.id}>
                <Badge color="danger" onClick={()=> {
                    this.props.removeFromCart(product.product)
                }}>X</Badge>
              {"   "+ product.product.productName +" "}
              <Badge color="success">{product.quantity}</Badge>
            </DropdownItem>
          ))}

          <DropdownItem divider />
          <DropdownItem>
            <Link to="cart">Go To Cart</Link>
          </DropdownItem>
        </DropdownMenu>
      </UncontrolledDropdown>
    );
  }

  renderEmptyCart(){
    <NavItem>
        <NavLink >Empty Cart</NavLink>

    </NavItem>
  }

  render() {
    return <div>

        {this.props.cart.length > 0 ? this.renderSummary() : this.renderEmptyCart()}

    </div>;
  }
}
