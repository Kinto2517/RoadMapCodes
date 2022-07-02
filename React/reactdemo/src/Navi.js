import React, { Component } from "react";
import { Link } from "react-router-dom";

import {
  Navbar,
  NavbarBrand,
  NavbarToggler,
  Collapse,
  Nav,
  NavItem,
  NavLink,
  NavbarText,
} from "reactstrap";
import CartSummary from "./CartSummary";

export default class Navi extends Component {
  render() {
    return (
      <div>
        <Navbar color="light" expand="md" light>
          <NavbarBrand href="/">reactstrap</NavbarBrand>
          <NavbarToggler onClick={function noRefCheck() {}} />
          <Collapse navbar>
            <Nav className="me-auto" navbar>
              <NavItem>
                <NavLink>
                  <Link to="form1">Form1</Link>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink>
                  <Link to="form2">Form2</Link>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="https://github.com/Kinto2517">GitHub</NavLink>
              </NavItem>
              <CartSummary
                removeFromCart={this.props.removeFromCart}
                cart={this.props.cart}
              ></CartSummary>
            </Nav>
            <NavbarText>Simple Text</NavbarText>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}
