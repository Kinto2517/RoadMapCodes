import React, { Component } from "react";
import { Grid } from "@material-ui/core";
import insta_img from "../../images/logoinsta.png"

class LoginPage extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div>
        <Grid container>
          <Grid item xs={3}>
           
          </Grid>
          <Grid item xs={6}>
            <div>
            <img src={insta_img}/> 
            </div>
            <div>

            </div>

          </Grid>
          <Grid item xs={3}>
        
          </Grid>
        </Grid>
      </div>
    );
  }
}

export default LoginPage;
