import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import { NavLink } from "react-router-dom";
import { styled } from "@mui/material/styles";

const useStyles = styled((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  link: {
    textDecoration: "none",
    color: "inherit",
  },
  title: {
    flexGrow: 1,
  },
}));

export default function Navbar() {
  let userId = 5;

  const classes = useStyles();

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>

          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            News
          </Typography>

          <NavLink
            style={{ textDecoration: "none" , color: "inherit"}}
            className={{ textDecoration: "none" }}
            to="/"
          >
            Home
          </NavLink>
          <Button color="inherit">Login</Button>
          <NavLink
            style={{ textDecoration: "none", color: "inherit" }}
            className={classes.link}
            to={{ pathname: "/users/" + userId }}
          >
            Users
          </NavLink>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
