import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { 
  Box, 
  Button, 
  Card, 
  CardContent, 
  Container, 
  Grid, 
  Typography, 
  CircularProgress
} from '@mui/material';
import { fetchProducts } from '../features/product/productSlice';
import ProductCard from '../components/product/ProductCard';

const HomePage = () => {
  const dispatch = useDispatch();
  const { products, loading } = useSelector((state) => state.product);

  useEffect(() => {
    dispatch(fetchProducts());
  }, [dispatch]);

  return (
    <div>
      {/* Hero Section */}
      <Box 
        sx={{ 
          bgcolor: 'primary.main', 
          color: 'white', 
          py: 8, 
          mb: 6,
          borderRadius: 2,
          backgroundImage: 'linear-gradient(135deg, #1565c0 0%, #0d47a1 100%)'
        }}
      >
        <Container maxWidth="lg">
          <Typography variant="h2" component="h1" gutterBottom>
            Welcome to CloudMart
          </Typography>
          <Typography variant="h5" component="p" paragraph>
            Your one-stop shop for quality products at affordable prices.
          </Typography>
          <Button 
            variant="contained" 
            color="secondary" 
            component={Link} 
            to="/products"
            size="large"
            sx={{ mt: 2 }}
          >
            Shop Now
          </Button>
        </Container>
      </Box>

      {/* Featured Products */}
      <Container maxWidth="lg">
        <Typography variant="h4" component="h2" align="center" gutterBottom>
          Featured Products
        </Typography>
        <Typography variant="subtitle1" align="center" color="text.secondary" paragraph>
          Check out our handpicked selection of popular items.
        </Typography>

        {loading ? (
          <Box sx={{ display: 'flex', justifyContent: 'center', mt: 4 }}>
            <CircularProgress />
          </Box>
        ) : (
          <Grid container spacing={4} sx={{ mt: 2 }}>
            {products.slice(0, 8).map((product) => (
              <Grid item key={product.id} xs={12} sm={6} md={3}>
                <ProductCard product={product} />
              </Grid>
            ))}
          </Grid>
        )}

        <Box sx={{ display: 'flex', justifyContent: 'center', mt: 4 }}>
          <Button 
            variant="outlined" 
            color="primary" 
            component={Link} 
            to="/products"
            size="large"
          >
            View All Products
          </Button>
        </Box>
      </Container>

      {/* Categories Section */}
      <Container maxWidth="lg" sx={{ mt: 8 }}>
        <Typography variant="h4" component="h2" align="center" gutterBottom>
          Shop by Category
        </Typography>
        <Grid container spacing={4} sx={{ mt: 2 }}>
          <Grid item xs={12} sm={6} md={4}>
            <Card sx={{ height: '100%' }}>
              <CardContent>
                <Typography variant="h5" component="div" gutterBottom>
                  Electronics
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                  Discover the latest gadgets and devices.
                </Typography>
                <Button 
                  component={Link} 
                  to="/products?category=electronics" 
                  color="primary"
                >
                  Explore
                </Button>
              </CardContent>
            </Card>
          </Grid>
          <Grid item xs={12} sm={6} md={4}>
            <Card sx={{ height: '100%' }}>
              <CardContent>
                <Typography variant="h5" component="div" gutterBottom>
                  Clothing
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                  Stay stylish with our clothing collection.
                </Typography>
                <Button 
                  component={Link} 
                  to="/products?category=clothing" 
                  color="primary"
                >
                  Explore
                </Button>
              </CardContent>
            </Card>
          </Grid>
          <Grid item xs={12} sm={6} md={4}>
            <Card sx={{ height: '100%' }}>
              <CardContent>
                <Typography variant="h5" component="div" gutterBottom>
                  Home & Kitchen
                </Typography>
                <Typography variant="body2" color="text.secondary" paragraph>
                  Everything you need for your home.
                </Typography>
                <Button 
                  component={Link} 
                  to="/products?category=home" 
                  color="primary"
                >
                  Explore
                </Button>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
      </Container>
    </div>
  );
};

export default HomePage;
